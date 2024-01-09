package hsh.demo.restdocs.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AssertJTest {


    @Test
    void assertThatTest() {
        int a = 1;
        int b = 2;
        int sum = a + b;
        Assertions.assertThat(sum).isEqualTo(3);
        Assertions.assertThat(sum).isNotEqualTo(4);
    }
}
