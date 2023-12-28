package hansanhha.spring.restdocs.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    @DisplayName("테스트1")
    @Test
    void successTest() {
        int a = 1;
        int b = 2;
        int sum = a + b;

        Assertions.assertEquals(a + b, sum);
    }

}
