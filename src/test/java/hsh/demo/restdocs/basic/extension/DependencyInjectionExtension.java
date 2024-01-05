package hsh.demo.restdocs.basic.extension;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class DependencyInjectionExtension implements BeforeTestExecutionCallback {

    /*
        * 테스트 컨텍스트의 인스턴스 획득
        * 인스턴스의 필드 목록 획득
        * 필드 목록 중 @RequireInject 필드 목록 획득
        * @RequireInject 필드에 의존성 주입
     */
    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        Object testInstance = extensionContext.getRequiredTestInstance();

        Field[] fields = getFields(testInstance);

        Field[] requireInjectedFields = getInjectedFields(fields);

        for (Field requireInjectedField : requireInjectedFields) {
            resolveDependency(requireInjectedField, testInstance);
        }
    }

    private Field[] getFields(Object testInstance) {
        return testInstance.getClass().getDeclaredFields();
    }

    private Field[] getInjectedFields(Field[] fields) {
        return Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(RequireInject.class))
                .toArray(Field[]::new);
    }

    /*
        * 주입할 객체 생성 (inject)
        * 필드의 타입 획득 (target - injectedType)
        * 타입의 생성자 획득 (target)
        * 생성자의 접근성 변경 (target)
        * 생성자를 통해 의존성 주입 (target)
        * 테스트 컨텍스트 인스턴스의 필드에 생성된 객체(target) 세팅
        * 간단한 테스트를 위해 타입 추론 등 생략
     */
    public void resolveDependency(Field requireInjectedField, Object testInstance) throws Exception {
        InjectClass injectClass = new InjectClass();

        Class<?> injectedType = requireInjectedField.getType();

        Constructor<?> constructor = injectedType.getDeclaredConstructor(InjectClass.class);

        constructor.setAccessible(true);

        Object injectedObject = constructor.newInstance(injectClass);

        requireInjectedField.setAccessible(true);
        requireInjectedField.set(testInstance, injectedObject);
    }
}
