package hansanhha.spring.restdocs.basic;

import hansanhha.spring.restdocs.basic.controller.HomeController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private HomeController controller;

    @Test
    void contextLoads() {
        Assertions.assertThat(controller).isNotNull();
    }
}
