package com.study.restdocs.controller;

import com.study.restdocs.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class HomeController {

    public final GreetingService greetingService;

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return greetingService.greet();
    }
}
