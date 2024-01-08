package hsh.demo.restdocs.notes;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public RepresentationModel<?> index() {
        RepresentationModel<?> index = new RepresentationModel<>();
        index.add(linkTo(NotesController.class).withRel("notes"));
        index.add(linkTo(TagsController.class).withRel("tags"));
        return index;
    }
}
