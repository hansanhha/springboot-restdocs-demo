package hsh.demo.restdocs.notes;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static hsh.demo.restdocs.notes.NoteRepresentationModelAssembler.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class NoteRepresentationModelAssembler extends RepresentationModelAssemblerSupport<Note, NoteModel> {

    NoteRepresentationModelAssembler() {
        super(NotesController.class, NoteModel.class);
    }

    @Override
    public NoteModel toModel(Note entity) {
        NoteModel noteModel = createModelWithId(entity.getId(), entity);
        noteModel.add(linkTo(methodOn(NotesController.class).noteTags(entity.getId())).withRel("note-tags"));
        return noteModel;
    }

    @Override
    protected NoteModel instantiateModel(Note entity) {
        return new NoteModel(entity);
    }

    @Relation(collectionRelation = "notes", itemRelation = "note")
    static class NoteModel extends RepresentationModel<NoteModel> {

        private final Note note;


        NoteModel(Note note) {
            this.note = note;
        }

        public String getTitle() {
            return note.getTitle();
        }

        public String getBody() {
            return note.getBody();
        }
    }
}
