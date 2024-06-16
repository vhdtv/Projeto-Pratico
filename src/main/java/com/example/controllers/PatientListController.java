package com.example.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.PatientModel;
import com.example.repositories.AttendanceRegistrationRepository;
import com.example.repositories.PatientRepository;

@Controller
@RequestMapping("/patient")
public class PatientListController {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    AttendanceRegistrationRepository attendanceRegistrationRepository;

    @GetMapping({ "/list", "/list/" })
    public String list(Model context) {
        List<HashMap<String, String>> patientHash = new ArrayList<>();
        List<PatientModel> patients = this.patientRepository.findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (PatientModel patient : patients) {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("name", patient.getName());
            item.put("birthday", dateFormat.format(patient.getBirthday()));
            item.put("motherName", patient.getMotherName());
            item.put("fatherName", patient.getFatherName());
            item.put("attendanceCount",
                    Integer.toString(this.attendanceRegistrationRepository.findAllByPatient(patient).size()));
            patientHash.add(item);
        }
        context.addAttribute("patientList", patientHash);
        return "pages/patient-list";
    }
}