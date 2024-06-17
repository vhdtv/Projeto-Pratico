package com.example.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.PatientCreationDto;
import com.example.dto.PatientRecordDto;
import com.example.dto.SymptomXrefHandlerDto;
import com.example.models.PatientModel;
import com.example.repositories.AttendanceRegistrationRepository;
import com.example.repositories.GenreRepository;
import com.example.repositories.PatientRepository;
import com.example.repositories.SymptomRepository;
import com.example.services.PatientService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    AttendanceRegistrationRepository attendanceRegistrationRepository;
    @Autowired
    SymptomRepository symptomRepository;

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

    @GetMapping({ "/create", "/create/" })
    public String createForm(Model context) {
        context.addAttribute("genreList", this.genreRepository.findAll());
        PatientCreationDto patientRecord = new PatientCreationDto();

        for (int i = 0; i < 4; i++)
            patientRecord.addXSymptom(new SymptomXrefHandlerDto());

        context.addAttribute("patientRecord", patientRecord);
        context.addAttribute("symptomList", this.symptomRepository.findAll());
        return "pages/patient-create";
    }

    @PostMapping({ "/", "" })
    public void add(@Valid @RequestBody @ModelAttribute("patientRecordDto") PatientCreationDto patientCreationDto) {
        // PatientModel patient = new PatientModel();
        // patient.setBirthday(PatientService.generateBirthdayValue(patientCreationDto.getBirthday()));
        // patient.setEmail(patientCreationDto.getEmail());
        // patient.setFatherName(patientCreationDto.getFatherName());
        // patient.setPhoneNumber(patientCreationDto.getPhoneNumber());

        // System.out.println();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}