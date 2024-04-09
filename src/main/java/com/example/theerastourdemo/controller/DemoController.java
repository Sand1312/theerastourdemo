package com.example.theerastourdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/leaders")
    public String showleaders() {
        return "leaders";
    }

    @GetMapping("/systems")
    public String showAdmins() {
        return "systems";
    }
}
