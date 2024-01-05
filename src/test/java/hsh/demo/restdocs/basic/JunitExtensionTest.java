package hsh.demo.restdocs.basic;

import hsh.demo.restdocs.basic.extension.DependencyInjectionExtension;
import hsh.demo.restdocs.basic.extension.HelloService;
import hsh.demo.restdocs.basic.extension.HomeService;
import hsh.demo.restdocs.basic.extension.RequireInject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@DisplayName("JUnit5 @ExtendWith 테스트")
@ExtendWith(DependencyInjectionExtension.class)
public class JunitExtensionTest {

    @RequireInject
    private HelloService helloService;

    @RequireInject
    private HomeService homeService;

    @DisplayName("Extension 의존성 주입 테스트")
    @Test
    void extensionInjectTest() {
        System.out.println("helloService = " + helloService.say());
        System.out.println("homeService = " + homeService.say());
    }
}
