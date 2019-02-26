package com.task.sberproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String ajax() {
        return "ajax";
    }

    @Deprecated
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
