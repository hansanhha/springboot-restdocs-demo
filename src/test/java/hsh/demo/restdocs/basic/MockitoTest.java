package hsh.demo.restdocs.basic;

import hsh.demo.restdocs.basic.service.GreetingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@DisplayName("Mockito 테스트")
@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    @Mock
    GreetingService greetingService;

}
