package medical.clinic.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWord {

    @GetMapping
    public String helloWord() {
        return "Vai estudar vagabunda, já acabou jessica?";
    }

}
