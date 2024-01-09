package hsh.demo.restdocs.cafes;

import org.springframework.data.repository.CrudRepository;

interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
