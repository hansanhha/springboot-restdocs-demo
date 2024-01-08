package hsh.demo.restdocs.notes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
class TagInput {

    @NotBlank
    private final String name;

    @JsonCreator
    public TagInput(@NotBlank @JsonProperty("name") String name) {
        this.name = name;
    }
}
