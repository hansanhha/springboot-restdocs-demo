package hsh.demo.restdocs.notes;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@ExtendWith(RestDocumentationExtension.class)
public class ApiDocumentation {

//    private RestDocumentationResultHandler documentationHandler;
//
//    @Autowired
//    private NoteRepository noteRepository;
//
//    @Autowired
//    private TagRepository tagRepository;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setUp(RestDocumentationContextProvider restDocumentation) {
//        documentationHandler = document("{method-name}",
//                preprocessRequest(prettyPrint()),
//                preprocessResponse(prettyPrint()));
//
//        mockMvc = MockMvcBuilders.webAppContextSetup(context)
//                .apply(documentationConfiguration(restDocumentation))
//                .alwaysDo(documentationHandler)
//                .build();
//    }
//
//    @Test
//    void headersExample() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andDo(documentationHandler.document(
//                        responseHeaders(
//                                headerWithName(HttpHeaders.CONTENT_TYPE).description("The Content-Type of the payload, e.g. `application/hal+json`")
//                        )
//                ));
//    }
//
//    @Test
//    void errorExample() throws Exception {
//        mockMvc.perform(get("/error")
//                        .requestAttr(RequestDispatcher.ERROR_STATUS_CODE, 400)
//                        .requestAttr(RequestDispatcher.ERROR_REQUEST_URI, "/notes")
//                        .requestAttr(RequestDispatcher.ERROR_MESSAGE, "The tag 'http://localhost:8080/tags/123' does not exist"))
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath("error", is(HttpStatus.BAD_REQUEST.getReasonPhrase())))
//                .andExpect(jsonPath("timestamp", is(notNullValue())))
//                .andExpect(jsonPath("status", is(HttpStatus.BAD_REQUEST.value())))
//                .andExpect(jsonPath("path", is(notNullValue())))
//                .andDo(documentationHandler.document(
//                        responseFields(
//                                fieldWithPath("error").description("The HTTP error that occurred, e.g. `Bad Request`"),
//                                fieldWithPath("message").description("A description of the cause of the error"),
//                                fieldWithPath("path").description("The path to which the request was made"),
//                                fieldWithPath("status").description("The HTTP status code, e.g. `400`"),
//                                fieldWithPath("timestamp").description("The time, in milliseconds, at which the error occurred")
//                        )
//                ));
//    }
//
//    @Test
//    void indexExample() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andDo(documentationHandler.document(
//                        links(
//                            linkWithRel("notes").description("The <<resources_notes,Notes resource>>"),
//                            linkWithRel("tags").description("The <<resources_tags,Tags resource>>")),
//                        responseFields(
//                                subsectionWithPath("_links").description("<<resources_index_access_links,Links>> to other resources")
//                        )
//                ));
//    }
//
//    @Test
//    void notesListExample() throws Exception {
//        noteRepository.deleteAll();
//
//        createNote("REST maturity model", "http://martinfowler.com/articles/richardsonMaturityModel.html");
//        createNote("Hypertext Application Language (HAL)", "https://github.com/mikekelly/hal_specification");
//        createNote("Application-Level Profile Semantics (ALPS)", "https://github.com/alps-io/spec");
//
//        mockMvc.perform(get("/notes"))
//                .andExpect(status().isOk())
//                .andDo(documentationHandler.document(
//                        responseFields(
//                                subsectionWithPath("_embedded.notes").description("An array of <<resources_note, Note resources>>")
//                        )
//                ));
//    }
//
//    @Test
//    void notesCreateExample() throws Exception {
//        Map<String, String> tag = Map.of("name", "REST");
//
//        String tagLocation = mockMvc.perform(post("/tags")
//                        .contentType(MediaTypes.HAL_JSON)
//                        .content(objectMapper.writeValueAsString(tag)))
//                .andExpect(status().isCreated())
//                .andReturn().getResponse().getHeader(HttpHeaders.LOCATION);
//
//        Map<String, Object> note = Map.of(
//                "title", "REST maturity model",
//                "body", "http://martinfowler.com/articles/richardsonMaturityModel.html",
//                "tags", List.of(tagLocation)
//        );
//
//        ConstrainedFields fields = new ConstrainedFields(NoteInput.class);
//
//        mockMvc.perform(post("/notes")
//                    .contentType(MediaTypes.HAL_JSON)
//                    .content(objectMapper.writeValueAsString(note)))
//                .andExpect(status().isCreated())
//                .andDo(documentationHandler.document(
//                        requestFields(
//                                fields.withPath("title").description("The title of the note"),
//                                fields.withPath("body").description("The body of the note"),
//                                fields.withPath("tags").description("An array of tag resource URIs")
//                        )
//                ));
//
//    }
//
//    @Test
//    void noteGetExample() throws Exception {
//        Map<String, String> tag = Map.of("name", "REST");
//
//        String tagLocation = mockMvc.perform(post("/tags")
//                        .contentType(MediaTypes.HAL_JSON)
//                        .content(objectMapper.writeValueAsString(tag)))
//                .andExpect(status().isCreated())
//                .andReturn().getResponse().getHeader(HttpHeaders.LOCATION);
//
//        Map<String, Object> note = Map.of(
//                "title", "REST maturity model",
//                "body", "http://martinfowler.com/articles/richardsonMaturityModel.html",
//                "tags", List.of(tagLocation)
//        );
//
//        String noteLocation = mockMvc.perform(post("/notes")
//                        .contentType(MediaTypes.HAL_JSON)
//                        .content(objectMapper.writeValueAsString(note)))
//                .andExpect(status().isCreated())
//                .andReturn().getResponse().getHeader(HttpHeaders.LOCATION);
//
//        mockMvc.perform(get(noteLocation))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("title", is(note.get("title"))))
//                .andExpect(jsonPath("body", is(note.get("body"))))
//                .andExpect(jsonPath("_links.self.href", is(noteLocation)))
//                .andExpect(jsonPath("_links.note-tags", is(notNullValue())))
//                .andDo(documentationHandler.document(
//                        links(
//                                linkWithRel("self").description("This <<resources_note,notes>>"),
//                                linkWithRel("note-tags").description("this note's tags")),
//                        responseFields(
//                                fieldWithPath("title").description("The title of the note"),
//                                fieldWithPath("body").description("The body of the note"),
//                                subsectionWithPath("_links").description("<<resources_note_links,Links>> to other resources")
//                        )
//                ));
//    }
//
//    private void createNote(String title, String body) {
//        Note note = new Note();
//        note.setTitle(title);
//        note.setBody(body);
//
//        noteRepository.save(note);
//    }
//
//    private void createTag(String name) {
//        Tag tag = new Tag();
//        tag.setName(name);
//
//        tagRepository.save(tag);
//    }
//
//    private static class ConstrainedFields {
//        private final ConstraintDescriptions constraintDescriptions;
//
//        public ConstrainedFields(Class<?> input) {
//            this.constraintDescriptions = new ConstraintDescriptions(input);
//        }
//
//        private FieldDescriptor withPath(String path) {
//            return fieldWithPath(path).attributes(
//                    key("constraints").value(StringUtils.collectionToDelimitedString(
//                                    constraintDescriptions.descriptionsForProperty(path), ". ")));
//        }
//    }

}
