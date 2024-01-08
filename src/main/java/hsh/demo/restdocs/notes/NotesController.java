package hsh.demo.restdocs.notes;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static hsh.demo.restdocs.notes.NoteRepresentationModelAssembler.*;
import static hsh.demo.restdocs.notes.TagRepresentationModelAssembler.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
class NotesController {

    private static final UriTemplate TAG_URI_TEMPLATE = new UriTemplate("/tags/{id}");

    private final NoteRepository noteRepository;

    private final TagRepository tagRepository;

    private final NoteRepresentationModelAssembler noteAssembler;

    private final TagRepresentationModelAssembler tagAssembler;

    @GetMapping
    CollectionModel<NoteModel> all() {
        return noteAssembler.toCollectionModel(noteRepository.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    HttpHeaders create(@RequestBody NoteInput noteInput) {
        Note newNote = new Note();
        newNote.setTitle(noteInput.getTitle());
        newNote.setBody(noteInput.getBody());
        newNote.setTags(getTags(noteInput.getTagUris()));

        noteRepository.save(newNote);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(linkTo(NotesController.class).slash(newNote.getId()).toUri());

        return httpHeaders;
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable("id") long id) {
        noteRepository.deleteById(id);
    }

    @GetMapping(path ="/{id}")
    NoteModel note(@PathVariable("id") long id) {
        return noteAssembler.toModel(findNoteById(id));
    }

    @GetMapping(path ="/{id}/tags")
    CollectionModel<TagModel> noteTags(@PathVariable("id") long id) {
        return tagAssembler.toCollectionModel(findNoteById(id).getTags());
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateNote(@PathVariable("id") long id, @RequestBody NotePatchInput notePatchInput) {
        Note foundNote = findNoteById(id);

        if (notePatchInput.getTagUris() != null) {
            foundNote.setTags(getTags(notePatchInput.getTagUris()));
        }

        if (notePatchInput.getTitle() != null) {
            foundNote.setTitle(notePatchInput.getTitle());
        }

        if (notePatchInput.getBody() != null) {
            foundNote.setBody(notePatchInput.getBody());
        }

        noteRepository.save(foundNote);

    }

    private Note findNoteById(long id) {
        return noteRepository.findById(id).orElseThrow(ResourceDoesNotExistException::new);
    }

    private List<Tag> getTags(List<URI> tagLocations) {
        ArrayList<Tag> tags = new ArrayList<>(tagLocations.size());

        tagLocations.forEach(tagLocation -> {
            Optional<Tag> foundTag = tagRepository.findById(extractTagId(tagLocation));

            if (foundTag.isEmpty()) {
                throw new IllegalArgumentException("The tag '" + tagLocation + "' does not exist");
            }

            tags.add(foundTag.get());
        });

        return tags;
    }

    private long extractTagId(URI tagLocation) {
        try {
            String idString = TAG_URI_TEMPLATE.match(tagLocation.toASCIIString()).get("id");

            return Long.parseLong(idString);
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException("The tag location '" + tagLocation + "' is invalid");
        }
    }


}
