package hsh.demo.restdocs.cafes;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cafes")
@RequiredArgsConstructor
class CafesController {

    private final CafeRepository cafeRepository;
    private final CoffeeRepository coffeeRepository;

    @GetMapping
    List<Cafe> getAll() {
        return (List<Cafe>) cafeRepository.findAll();
    }

    @GetMapping("/{cafeId}")
    Cafe get(@PathVariable("cafeId") Long cafeId) {
        return cafeRepository.findById(cafeId)
                .orElseThrow(() -> new IllegalArgumentException("Cafe not found"));
    }

    @PostMapping
    CafeCreateResponse create(CafeCreateRequest request) {
        Cafe cafe = new Cafe();
        cafe.setName(request.getName());
        cafe.setAddress(request.getAddress());

        Long id = cafeRepository.save(cafe).getId();

        return new CafeCreateResponse(id);
    }

    @PostMapping("/{cafeId}/{coffeeId}")
    void addMenu(@PathVariable("cafeId") Long cafeId,
                 @PathVariable("coffeeId") Long coffeeId) {

        Cafe cafe = cafeRepository.findById(cafeId)
                .orElseThrow(() -> new IllegalArgumentException("Cafe not found"));

        Coffee coffee = coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new IllegalArgumentException("Coffee not found"));

        cafe.setCoffee(coffee);
    }

}
