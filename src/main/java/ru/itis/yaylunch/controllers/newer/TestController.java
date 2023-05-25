package ru.itis.yaylunch.controllers.newer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @PostMapping
    public void post(@PathVariable String name) {
        System.out.println(name);
    }
}
