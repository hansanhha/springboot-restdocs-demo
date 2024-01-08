package hsh.demo.restdocs.notes;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.inspector.TagInspector;

import static hsh.demo.restdocs.notes.NoteRepresentationModelAssembler.*;
import static hsh.demo.restdocs.notes.TagRepresentationModelAssembler.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("tags")
@RequiredArgsConstructor
class TagsController {

    private final TagRepository tagRepository;

    private final TagRepresentationModelAssembler tagAssembler;

    private final NoteRepresentationModelAssembler noteAssembler;

    @GetMapping
    CollectionModel<TagModel> all() {
        return tagAssembler.toCollectionModel(tagRepository.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    HttpHeaders create(@RequestBody TagInput tagInput) {
        Tag newTag = new Tag();
        newTag.setName(tagInput.getName());

        tagRepository.save(newTag);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(linkTo(TagsController.class).slash(newTag.getId()).toUri());

        return httpHeaders;
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable("id") long id) {
        tagRepository.deleteById(id);
    }

    @GetMapping(path = "/{id}")
    TagModel tag(@PathVariable("id") long id) {
        return tagAssembler.toModel(findTagById(id));
    }

    @GetMapping(path = "/{id}/notes")
    CollectionModel<NoteModel> tagNotes(@PathVariable("id") long id) {
        return noteAssembler.toCollectionModel(findTagById(id).getNotes());
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateTag(@PathVariable("id") long id, @RequestBody TagPatchInput tagPatchInput) {
        Tag tagById = findTagById(id);

        if (tagPatchInput.getName() != null) {
            tagById.setName(tagPatchInput.getName());
        }

        tagRepository.save(tagById);
    }

    private Tag findTagById(long id) {
        return tagRepository.findById(id).orElseThrow(ResourceDoesNotExistException::new);
    }

}
