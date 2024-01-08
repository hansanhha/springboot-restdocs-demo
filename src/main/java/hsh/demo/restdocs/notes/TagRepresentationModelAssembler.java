package hsh.demo.restdocs.notes;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static hsh.demo.restdocs.notes.TagRepresentationModelAssembler.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class TagRepresentationModelAssembler extends RepresentationModelAssemblerSupport<Tag, TagModel> {

    public TagRepresentationModelAssembler() {
        super(TagsController.class, TagModel.class);
    }

    @Override
    public TagModel toModel(Tag entity) {
        TagModel tagModel = new TagModel(entity);
        tagModel.add(linkTo(methodOn(TagsController.class).tag(entity.getId())).withSelfRel(),
                linkTo(methodOn(TagsController.class).tagNotes(entity.getId())).withRel("tagged-notes"));
        return tagModel;
    }

    @Override
    protected TagModel instantiateModel(Tag entity) {
        return new TagModel(entity);
    }

    @Relation(collectionRelation = "tags", itemRelation = "tag")
    static class TagModel extends RepresentationModel<TagModel> {

            private final Tag tag;

            TagModel(Tag tag) {
                this.tag = tag;
            }

            public String getName() {
                return tag.getName();
            }
    }
}
