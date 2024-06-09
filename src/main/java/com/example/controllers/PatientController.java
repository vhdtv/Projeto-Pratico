package com.example.controllers;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PatientRecordDto;
import com.example.models.PatientModel;
import com.example.repositories.PatientRepository;

import jakarta.validation.Valid;

@RestController
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/patient")
    public ResponseEntity<PatientModel> savePatient(@RequestBody @Valid PatientRecordDto patientRecordDto) {
        PatientModel patientModel = new PatientModel(UUID.randomUUID());
        BeanUtils.copyProperties(patientRecordDto, patientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientRepository.save(patientModel));
    }
}