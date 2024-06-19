package com.example.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.example.dto.SymptomXrefHandlerDto;
import com.example.models.PatientModel;
import com.example.models.PatientXrefSymptomModel;
import com.example.models.PriorityModel;
import com.example.models.ReportModel;
import com.example.models.ReportXrefSymptomsModel;
import com.example.models.SymptomModel;
import com.example.repositories.AttendanceRegistrationRepository;
import com.example.repositories.AttendantRepository;
import com.example.repositories.GenreRepository;
import com.example.repositories.PatientRepository;
import com.example.repositories.PatientXrefSymptomRepository;
import com.example.repositories.PriorityRepository;
import com.example.repositories.ReportRepository;
import com.example.repositories.ReportXrefSymptomRepository;
import com.example.repositories.SymptomRepository;

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
    @Autowired
    PatientXrefSymptomRepository patientXrefSymptomRepository;
    @Autowired
    ReportXrefSymptomRepository ReportXrefSymptomRepository;
    @Autowired
    ReportRepository reportRepository;
    @Autowired
    PriorityRepository priorityRepository;
    @Autowired
    AttendantRepository attendantRepository;

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
        /** Patient save */
        PatientModel patient = new PatientModel();
        BeanUtils.copyProperties(patientCreationDto.getPatient(), patient);
        patient.setBirthday(patientCreationDto.getPatient().getBirthday());
        this.patientRepository.save(patient);
        /** Report save */
        ReportModel report = new ReportModel();
        report.setAttendant(this.attendantRepository.findByUsername("pietra_aurora_rebeca_mendes").get());
        report.setCreatedAt(new Date());
        report.setPatient(patient);

        Set<ReportXrefSymptomsModel> reportSymptoms = new HashSet<ReportXrefSymptomsModel>();
        Set<PatientXrefSymptomModel> patientSymptoms = new HashSet<PatientXrefSymptomModel>();
        ArrayList<SymptomModel> symptoms = new ArrayList<>();
        for (SymptomXrefHandlerDto symptomData : patientCreationDto.getXSymptoms()) {
            SymptomModel symptom = symptomData.getSymptomModel();
            symptoms.add(symptom);

            /** First save */
            PatientXrefSymptomModel patientXrefSymptom = new PatientXrefSymptomModel();
            patientXrefSymptom.setAnnotations(symptomData.getAnnotations().orElse(null));
            patientXrefSymptom.setAttendanceRegistration(report);
            if (symptomData.getAverageDays().isPresent())
                patientXrefSymptom.setAverageDays(symptomData.getAverageDays().get());
            if (symptomData.getIntensity().isPresent())
                patientXrefSymptom.setIntensity(symptomData.getIntensity().get());
            patientXrefSymptom.setPatient(patient);
            patientXrefSymptom.setSymptom(symptom);
            patientSymptoms.add(patientXrefSymptom);
        }
        report.setPriority(this.calculatePriority(symptoms));
        report.setSymptoms(reportSymptoms);
        this.reportRepository.save(report);
        for (PatientXrefSymptomModel symptomData : patientSymptoms)
            this.patientXrefSymptomRepository.save(symptomData);
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

    private PriorityModel calculatePriority(List<SymptomModel> symptoms) {
        PriorityModel priority = this.priorityRepository.findById(1).get();
        int totalScore = 0;
        for (SymptomModel s : symptoms)
            totalScore += s.getWeight();

        if (totalScore < 5)
            priority = this.priorityRepository.findById(2).get();
        else if (totalScore < 7)
            priority = this.priorityRepository.findById(3).get();
        else if (totalScore < 8)
            priority = this.priorityRepository.findById(4).get();

        return priority;
    }
}