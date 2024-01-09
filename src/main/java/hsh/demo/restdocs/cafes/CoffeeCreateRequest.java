package hsh.demo.restdocs.cafes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CoffeeCreateRequest {

    @JsonCreator
    public CoffeeCreateRequest(@JsonProperty("name") String name,
                               @JsonProperty("price") Integer price) {
        this.name = name;
        this.price = price;
    }

    private final String name;
    private final Integer price;
}
