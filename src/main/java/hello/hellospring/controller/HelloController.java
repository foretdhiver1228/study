package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        // value 에 command + p
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // body 부에 이 내용을직접 넣어주겠다 라는 어노테이션 = responseBody
    }

    @GetMapping("hello-api") // api타입이라 말하는 그것
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // JSON방식으로 리턴됨 key : value 구조.
    }

    static class Hello {
        private String name;
        public String getName() { // 프로퍼티 접근방식이라고도 함 getter setter를...
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }
}
