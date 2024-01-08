package hsh.demo.restdocs.notes;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface NoteRepository extends CrudRepository<Note, Long> {

    Optional<Note> findById(long id);

    List<Note> findByTagsIn(Collection<Tag> tags);
}
