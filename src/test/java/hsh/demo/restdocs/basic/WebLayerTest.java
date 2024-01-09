package hsh.demo.restdocs.basic;

import hsh.demo.restdocs.basic.controller.HomeController;
import hsh.demo.restdocs.basic.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(HomeController.class)
public class WebLayerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private GreetingService greetingService;
//
//    @Test
//    void shouldReturnDefaultMessage() throws Exception {
//        when(greetingService.greet()).thenReturn("Hello, World");
//
//        mockMvc.perform(get("/"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello, World")));
//    }
}
