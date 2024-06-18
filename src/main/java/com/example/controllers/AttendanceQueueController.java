package com.example.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.ReportModel;
import com.example.models.ReportXrefSymptomsModel;
import com.example.models.SymptomModel;
import com.example.models.PriorityModel;
import com.example.repositories.AttendanceRegistrationRepository;
import com.example.repositories.ReportXrefSymptomsRepository;
import com.example.repositories.SymptomRepository;
import com.example.repositories.PriorityRepository;

@Controller
@RequestMapping("/queue")
public class AttendanceQueueController {
    @Autowired
    AttendanceRegistrationRepository attendanceRegistrationRepository;
    
    @Autowired
    ReportXrefSymptomsRepository reportXrefSymptomsRepository;
    
    @Autowired
    SymptomRepository symptomRepository;
    
    @Autowired
    PriorityRepository priorityRepository;

    @GetMapping({ "/", "" })
    public String getPage(Model context) {
        List<ReportModel> queue = attendanceRegistrationRepository.findAllByUpdatedAtEquals(null);
        Map<ReportModel, Integer> reportWeightMap = new HashMap<>();
        
        for (ReportModel report : queue) {
            int totalSumWeight = 0;
            List<ReportXrefSymptomsModel> symptomsList = reportXrefSymptomsRepository.findAllByReportEquals(report);
            
            for (ReportXrefSymptomsModel symptom : symptomsList) {
                SymptomModel symptomData = symptomRepository.findById(symptom.getSymptom().getUuid()).orElse(null);
                if (symptomData != null) {
                    totalSumWeight += symptomData.getWeight();
                }
            }

            reportWeightMap.put(report, totalSumWeight);
            PriorityModel priority = determinePriority(totalSumWeight);
            if (priority != null) {
                report.setPriority(priority);
                attendanceRegistrationRepository.save(report);
            } else {
                // Handle case where no priority is found
                System.out.println("No priority found for totalSumWeight: " + totalSumWeight);
            }
        }

        queue.sort((r1, r2) -> reportWeightMap.get(r2) - reportWeightMap.get(r1));
        context.addAttribute("queue", queue);
        return "pages/queue";
    }

    private PriorityModel determinePriority(int totalSumWeight) {
        if (totalSumWeight >= 16) {
            return priorityRepository.findByDescription("Emergência");
        } else if (totalSumWeight >= 11) {
            return priorityRepository.findByDescription("Urgência");
        } else if (totalSumWeight >= 6) {
            return priorityRepository.findByDescription("Pouca Urgência");
        } else {
            return priorityRepository.findByDescription("Não Urgente");
        }
    }
}