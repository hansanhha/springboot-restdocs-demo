package hsh.demo.restdocs.notes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TagPatchInput {


    @NullOrNotBlank
    private final String name;

    @JsonCreator

    public TagPatchInput(@NullOrNotBlank @JsonProperty("name") String name) {
        this.name = name;
    }
}
