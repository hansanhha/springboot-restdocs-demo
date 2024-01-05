package hsh.demo.restdocs.basic.extension;

public class HelloService {

    private final InjectClass injectClass;

    public HelloService(InjectClass injectClass) {
        this.injectClass = injectClass;
    }

    public String say() {
        return injectClass.injectMethod();
    }
}
