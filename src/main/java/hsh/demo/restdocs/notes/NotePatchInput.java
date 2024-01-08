package hsh.demo.restdocs.notes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Getter
class NotePatchInput {

    @NullOrNotBlank
    private final String title;

    private final String body;

    @JsonProperty("tags")
    private final List<URI> tagUris;

    @JsonCreator
    public NotePatchInput(@JsonProperty("title") String title,
                          @JsonProperty("body") String body,
                          @JsonProperty("tags") List<URI> tagUris) {
        this.title = title;
        this.body = body;
        this.tagUris = tagUris == null ? Collections.<URI>emptyList() : tagUris;
    }
}
