package com.example.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            report.setTotalScore(totalSumWeight);

            reportWeightMap.put(report, totalSumWeight);
            // PriorityModel priority = determinePriority(totalSumWeight);
            // report.setPriority(priority);
            attendanceRegistrationRepository.save(report);
        }
        
        // Collections.sort(queue, Comparator.comparing(ReportModel::getTotalScore));
        // .thenComparing(ReportModel::getTotalScore));
        // queue.sort((r1, r2) -> reportWeightMap.get(r2) - reportWeightMap.get(r1));
        List<ReportModel> emergenciaList = new ArrayList<>();
        List<ReportModel> urgenciaList = new ArrayList<>();
        List<ReportModel> poucaUrgenciaList = new ArrayList<>();
        List<ReportModel> naoUrgenteList = new ArrayList<>();

        emergenciaList = queue.stream()
                .filter(r1 -> r1.getPriority().getDescription().equals("Emergência"))
                .collect(Collectors.toList());
        urgenciaList = queue.stream()
                .filter(r1 -> r1.getPriority().getDescription().equals("Urgência"))
                .collect(Collectors.toList());
        poucaUrgenciaList = queue.stream()
                .filter(r1 -> r1.getPriority().getDescription().equals("Pouca Urgência"))
                .collect(Collectors.toList());
        naoUrgenteList = queue.stream()
                .filter(r1 -> r1.getPriority().getDescription().equals("Não Urgente"))
                .collect(Collectors.toList());
        
        Collections.sort(emergenciaList);
        Collections.sort(urgenciaList);
        Collections.sort(poucaUrgenciaList);
        Collections.sort(naoUrgenteList);
        List<ReportModel> finalQueue = Stream.of(emergenciaList, urgenciaList, poucaUrgenciaList, naoUrgenteList).flatMap(Collection::stream).collect(Collectors.toList());

        context.addAttribute("queue", finalQueue);
        return "pages/queue";
    }

    // private PriorityModel determinePriority(int totalSumWeight) {
    // PriorityModel priority;
    // if (totalSumWeight >= 15) {
    // priority = priorityRepository.findByDescription("Emergência");
    // } else if (totalSumWeight >= 10) {
    // priority = priorityRepository.findByDescription("Urgência");
    // } else if (totalSumWeight >= 5) {
    // priority = priorityRepository.findByDescription("Pouca Urgência");
    // } else {
    // priority = priorityRepository.findByDescription("Não Urgente");
    // }

    // if (priority == null) {
    // throw new RuntimeException("Priority not found for description with
    // totalSumWeight: " + totalSumWeight);
    // }

    // return priority;
    // }
}