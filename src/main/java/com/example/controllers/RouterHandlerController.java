package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class RouterHandlerController {
    @GetMapping("/")
    public String index(Model context) {
        context.addAttribute("game", "Mario");
        return "pages/index";
    }
}