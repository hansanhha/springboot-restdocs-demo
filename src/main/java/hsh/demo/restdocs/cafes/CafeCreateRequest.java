package hsh.demo.restdocs.cafes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CafeCreateRequest {

    @JsonCreator
    public CafeCreateRequest(@JsonProperty("name") String name,
                             @JsonProperty("address") String address) {
        this.name = name;
        this.address = address;
    }

    private final String name;
    private final String address;
}
