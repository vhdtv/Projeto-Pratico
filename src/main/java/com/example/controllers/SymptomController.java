package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.models.SymptomModel;
import com.example.repositories.SymptomRepository;

@RestController
public class SymptomController {
    @Autowired
    SymptomRepository symptomRepository;

    @GetMapping("/symptom")
    public ResponseEntity<List<SymptomModel>> listSymptoms() {
        return ResponseEntity.status(HttpStatus.OK).body(symptomRepository.findAll());
    }

}