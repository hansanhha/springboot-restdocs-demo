package hsh.demo.restdocs.cafes;

import lombok.Getter;

@Getter
public class CoffeeCreateResponse {

    public CoffeeCreateResponse(Long id) {
        this.id = id;
    }

    private final Long id;
}
