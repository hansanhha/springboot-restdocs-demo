package hsh.demo.restdocs.notes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
//@ExtendWith(RestDocumentationExtension.class)
public class GettingStartedDocumentation {

//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp(RestDocumentationContextProvider restDocumentation) {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
//                .apply(documentationConfiguration(restDocumentation))
//                .alwaysDo(document("{method-name}/{step}",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint())))
//                .build();
//    }
//
//    @Test
//    void index() throws Exception {
//        mockMvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("_links.notes", is(notNullValue())))
//                .andExpect(jsonPath("_links.tags", is(notNullValue())));
//    }
//
//    @Test
//    void creatingANote() throws JsonProcessingException, Exception {
//        String noteLocation = createNote();
//        MvcResult note = getNote(noteLocation);
//
//        String tagLocation = createTag();
//        getTag(tagLocation);
//
//        String taggedNoteLocation = createTaggedNote(tagLocation);
//        MvcResult taggedNote = getNote(taggedNoteLocation);
//        getTags(getLocation(taggedNote, "note-tags"));
//
//        tagExistingNote(noteLocation, tagLocation);
//        getTags(getLocation(note, "note-tags"));
//    }
//
//    private String createNote() throws Exception {
//        Map<String, String> noteRequest = Map.of(
//                "title", "Note creation with cURL",
//                "body", "An example of how to create a note using cURL");
//
//        return mockMvc.perform(post("/notes")
//                        .contentType(MediaTypes.HAL_JSON)
//                        .content(objectMapper.writeValueAsString(noteRequest)))
//                .andExpect(status().isCreated())
//                .andExpect(header().string(HttpHeaders.LOCATION, notNullValue()))
//                .andReturn().getResponse().getHeader(HttpHeaders.LOCATION);
//    }
//
//    private String createTaggedNote(String tag) throws Exception {
//        Map<String, Object> taggedNoteRequest = Map.of(
//                "title", "Tagged note creation with cURL",
//                "body", "An example of how to create a tagged note using cURL",
//                "tags", List.of(tag)
//        );
//
//        return mockMvc.perform(post("/notes")
//                    .contentType(MediaTypes.HAL_JSON)
//                    .content(objectMapper.writeValueAsString(taggedNoteRequest)))
//                .andExpect(status().isCreated())
//                .andExpect(header().string(HttpHeaders.LOCATION, notNullValue()))
//                .andReturn().getResponse().getHeader(HttpHeaders.LOCATION);
//    }
//
//    private MvcResult  getNote(String noteLocation) throws Exception {
//        return mockMvc.perform(get(noteLocation))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("title", is(notNullValue())))
//                .andExpect(jsonPath("body", is(notNullValue())))
//                .andExpect(jsonPath("_links.note-tags", is(notNullValue())))
//                .andReturn();
//    }
//
//    private String createTag() throws Exception {
//        Map<String, String> tagRequest = Map.of("name", "getting-started");
//
//        return mockMvc.perform(post("/tags")
//                        .contentType(MediaTypes.HAL_JSON)
//                        .content(objectMapper.writeValueAsString(tagRequest)))
//                .andExpect(status().isCreated())
//                .andExpect(header().string(HttpHeaders.LOCATION, notNullValue()))
//                .andReturn().getResponse().getHeader(HttpHeaders.LOCATION);
//    }
//
//    private void getTag(String tagLocation) throws Exception {
//        mockMvc.perform(get(tagLocation))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("name", is(notNullValue())))
//                .andExpect(jsonPath("_links.tagged-notes", is(notNullValue())));
//    }
//
//    private void getTags(String noteTagsLocation) throws Exception {
//        mockMvc.perform(get(noteTagsLocation))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("_embedded.tags", hasSize(1)));
//    }
//
//    private void tagExistingNote(String noteLocation, String tagLocation) throws Exception {
//        Map<String, Object> updateNoteRequest = Map.of("tags", List.of(tagLocation));
//
//        mockMvc.perform(patch(noteLocation)
//                        .contentType(MediaTypes.HAL_JSON)
//                        .content(objectMapper.writeValueAsString(updateNoteRequest)))
//                .andExpect(status().isNoContent());
//    }
//
//    private String getLocation(MvcResult result, String rel) throws UnsupportedEncodingException {
//        return JsonPath.parse(result.getResponse().getContentAsString())
//                .read("_links." + rel + ".href");
//    }

}
