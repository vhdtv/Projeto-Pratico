package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.repositories.PatientRepository;

@RestController
public class PatientController {
    @Autowired
    PatientRepository patientRepository;
}