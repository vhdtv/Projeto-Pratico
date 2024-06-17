package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repositories.AttendanceRegistrationRepository;

@Controller
@RequestMapping("/queue")
public class AttendanceQueueController {
    @Autowired
    AttendanceRegistrationRepository attendanceRegistrationRepository;

    @GetMapping({ "/", "" })
    public String getPage(Model context) {
        // context.addAttribute("");
        return "pages/queue";
    }
}