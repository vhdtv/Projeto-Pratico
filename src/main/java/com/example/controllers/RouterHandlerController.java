package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterHandlerController {
    @GetMapping("/beta")
    public String index() {
        return "pages/index";
    }
}