package hsh.demo.restdocs.basic.extension;

public class HomeService {

    private final InjectClass injectClass;

    public HomeService(InjectClass injectClass) {
        this.injectClass = injectClass;
    }

    public String say() {
        return injectClass.injectMethod();
    }
}
