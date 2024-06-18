package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.ReportModel;
import com.example.models.ReportXrefSymptomsModel;
import com.example.models.SymptomModel;
import com.example.repositories.AttendanceRegistrationRepository;
import com.example.repositories.ReportXrefSymptomsRepository;
import com.example.repositories.SymptomRepository;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/queue")
public class AttendanceQueueController {
    @Autowired
    AttendanceRegistrationRepository attendanceRegistrationRepository;
    @Autowired
    ReportXrefSymptomsRepository reportXrefSymptomsRepository;
    @Autowired
    SymptomRepository symptomRepository;

    @GetMapping({ "/", "" })
    public String getPage(Model context) {
        List<ReportModel> queue = attendanceRegistrationRepository.findAllByUpdatedAtEquals(null);
        // Fazer ordenação buble/insertion sort utilizando a variavel totalSumWeight
        // Fazer a ordenação dentro do primeiro for o segundo é responsável pela soma de weight
        for(ReportModel report : queue){
            int totalSumWeight = 0;
            List<ReportXrefSymptomsModel> symptomsList = reportXrefSymptomsRepository.findAllByReportEquals(report);
            for(ReportXrefSymptomsModel symptom : symptomsList){
                SymptomModel symptomData = symptomRepository.findById(symptom.getSymptom().getUuid()).get();
                totalSumWeight += symptomData.getWeight();

            }

        }
        
        context.addAttribute("queue", queue);
        return "pages/queue";
    }
    
    
}
