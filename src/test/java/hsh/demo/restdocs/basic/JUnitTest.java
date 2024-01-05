package hsh.demo.restdocs.basic;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.params.ParameterizedTest.*;

public class JUnitTest {

    /*
        전체 테스트에 @Order를 지정하지 않으면 적용되지 않음
     */
    @DisplayName("@Order-Integer.MIN_VALUE 테스트")
    @Test
    @Order(Integer.MIN_VALUE)
    void orderFirstTest() {}

    @DisplayName("@Order-Integer.MAX_VALUE 테스트")
    @Test
    @Order(Integer.MAX_VALUE)
    void orderLastTest() {}

    @DisplayName("반복 테스트")
    @RepeatedTest(value = 5, name = "{currentRepetition}/{totalRepetitions}")
    void repeatTest() {
        Random random = new Random();
        int a = random.nextInt();
        int b = random.nextInt();
        int sum = a + b;

        Assertions.assertEquals(a + b, sum);
    }

    @DisplayName("파라미터 테스트-ValueSource")
    @ParameterizedTest(name = DEFAULT_DISPLAY_NAME)
    @ValueSource(strings = {"hello", "junit5", "world", "!"})
    void parameterizedValueSourceTest(String message) {
        System.out.println(message);
    }

    @DisplayName("파라미터 테스트-EnumSource")
    @ParameterizedTest(name = DEFAULT_DISPLAY_NAME)
    @EnumSource(value = Result.class)
    void parameterizedEnumSourceTest(Result result) {
        System.out.println(result);
    }

    @DisplayName("파라미터 테스트-NullAndEmptySource")
    @ParameterizedTest(name = DEFAULT_DISPLAY_NAME)
    @NullAndEmptySource()
    void parameterizedNullAndEmptySourceTest(String message) {
        System.out.println(message);
    }

    /*
        @ParameterizedTest(name = "[" + INDEX_PLACEHOLDER + "]" + "이름={0}, 저자={1}, 가격={2}")
        파라미터 이름 커스텀 가능(name)
     */

    @DisplayName("파라미터 테스트-MethodSource")
    @ParameterizedTest(name=DEFAULT_DISPLAY_NAME)
    @MethodSource("bookProvider")
    void parameterizedMethodSourceTest(String title, String author, int price) {
        System.out.println(title + "(" + author + ")" + " : " + price);
    }

    /*
        속성 값으로 클래스 대신 람다를 사용할 수 없음
     */
    @DisplayName("파라미터 테스트-ArgumentsSource")
    @ParameterizedTest(name=DEFAULT_DISPLAY_NAME)
    @ArgumentsSource(BookArgumentProvider.class)
    void parameterizedArgumentsSourceTest(String title, String author, int price) {
        System.out.println(title + "(" + author + ")" + " : " + price);
    }

    @DisplayName("파라미터 테스트-CsvSource")
    @ParameterizedTest(name=DEFAULT_DISPLAY_NAME)
    @CsvSource(value = {"토비의 스프링, 이일민, 30000", "테스트 주도 개발, 켄트백, 10000", "클라우드 네이티브 자바, 조쉬롱, 25000"}, delimiter = ',')
    void parameterizedCsvSourceTest(String title, String author, int price) {
        System.out.println(title + "(" + author + ")" + " : " + price);
    }

    @DisplayName("파라미터 테스트-CsvFileSource")
    @ParameterizedTest(name=DEFAULT_DISPLAY_NAME)
    @CsvFileSource(resources = "/book.csv", numLinesToSkip = 1, delimiter = '-')
    void parameterizedCsvFileSourceTest(String title, String author, int price) {
        System.out.println(title + "(" + author + ")" + " : " + price);
    }

    static Stream<Arguments> bookProvider() {
        return Stream.of(
                Arguments.of("토비의 스프링", "이일민", 30000),
                Arguments.of("테스트 주도 개발", "켄트백", 10000),
                Arguments.of("클라우드 네이티브 자바", "조쉬롱", 25000)
        );
    }

    static class BookArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("토비의 스프링", "이일민", 30000),
                    Arguments.of("테스트 주도 개발", "켄트백", 10000),
                    Arguments.of("클라우드 네이티브 자바", "조쉬롱", 25000)
            );
        }
    }

    enum Result {
        SUCCESS, FAIL, ERROR
    }


}
