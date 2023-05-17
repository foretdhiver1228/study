package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!!");
        return "hello";
    }

    // 해야할 일 : 부트 기초 공부. 스프링 공부. 부트로 프로젝트 하나 만들기.
}
