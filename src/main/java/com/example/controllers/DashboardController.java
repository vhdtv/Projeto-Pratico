package com.example.controllers;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.ReportModel;
import com.example.repositories.AttendanceRegistrationRepository;
import com.example.repositories.PriorityRepository;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    PriorityRepository priorityRepository;
    @Autowired
    AttendanceRegistrationRepository attendanceRegistrationRepository;

    @GetMapping({ "/", "" })
    public String page(Model context) {
        List<ReportModel> attendanceRegistrations = this.attendanceRegistrationRepository.findAll();
        context.addAttribute("lastAttendanceRegistrations", attendanceRegistrations);
        int totalPacients = (int) this.attendanceRegistrationRepository.count();
        context.addAttribute("totalPatients", totalPacients);
        int totalHighPriorityPatients = this.attendanceRegistrationRepository
                .findAllByPriorityEquals(this.priorityRepository.findById(1).get()).size();
        context.addAttribute("totalHighPriorityPatients", totalHighPriorityPatients);
        long totalTime = 0;
        for (ReportModel register : attendanceRegistrations) {
            Date updatedAt = register.getUpdatedAt();
            if (updatedAt == null) {
                continue;
            }
            Date creaDateAt = register.getCreatedAt();
            long difference = updatedAt.getTime() - creaDateAt.getTime();
            totalTime += difference;
        }
        int numberOfRegistrations = attendanceRegistrations.size();
        String averageTime = "N/A";
        if (totalTime != 0) {
            long averageTimeMillis = totalTime / numberOfRegistrations;
            long averageTimeHours = TimeUnit.MILLISECONDS.toHours(averageTimeMillis);
            long averageTimeMinutes = TimeUnit.MILLISECONDS.toMinutes(averageTimeMillis) % 60;
            averageTime = averageTimeHours + "H " + averageTimeMinutes + "min";
        }
        context.addAttribute("averageTime", averageTime);
        return "pages/dashboard";
    }
}