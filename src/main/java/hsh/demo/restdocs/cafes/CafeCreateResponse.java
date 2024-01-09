package hsh.demo.restdocs.cafes;

import lombok.Getter;

@Getter
public class CafeCreateResponse {

    public CafeCreateResponse(Long id) {
        this.id = id;
    }

    private final Long id;

}
