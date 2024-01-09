package hsh.demo.restdocs.basic.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greet() {
        return "Hello, World";
    }

    public void printGreeting() {
        System.out.println(english());
        System.out.println(korean());
    }

    public String english() {
        return "Hello";
    }

    public String korean() {
        return "안녕하세요";
    }
}
