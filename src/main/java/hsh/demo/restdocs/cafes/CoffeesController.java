package hsh.demo.restdocs.cafes;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coffees")
@RequiredArgsConstructor
public class CoffeesController {

    private final CoffeeRepository coffeeRepository;

    @GetMapping
    List<Coffee> getAll() {
        return (List<Coffee>) coffeeRepository.findAll();
    }

    @GetMapping("/{coffeeId}")
    Coffee get(Long coffeeId) {
        return coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new IllegalArgumentException("Coffee not found"));
    }

    @PostMapping
    CoffeeCreateResponse create(CoffeeCreateRequest request) {
        Coffee coffee = new Coffee();
        coffee.setName(request.getName());
        coffee.setPrice(request.getPrice());

        Long id = coffeeRepository.save(coffee).getId();
        return new CoffeeCreateResponse(id);
    }

}
