package hsh.demo.restdocs.notes;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TagRepository extends CrudRepository<Tag, Long> {

    Optional<Tag> findById(long id);
}
