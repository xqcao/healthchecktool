package com.demo.autohealthcheck.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        return "Pong";
    }
}
