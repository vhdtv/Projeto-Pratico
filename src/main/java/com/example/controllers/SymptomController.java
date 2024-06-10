package com.example.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.SymptomRecordDto;
import com.example.models.SymptomModel;
import com.example.repositories.SymptomRepository;

import jakarta.validation.Valid;

@RestController
public class SymptomController {
    @Autowired
    SymptomRepository symptomRepository;

    @GetMapping("/symptom")
    public ResponseEntity<List<SymptomModel>> listSymptoms() {
        return ResponseEntity.status(HttpStatus.OK).body(symptomRepository.findAll());
    }

    @GetMapping("/symptom/{id}")
    public ResponseEntity<Optional<SymptomModel>> getSymptom(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(symptomRepository.findById(id));
    }
    
    @PostMapping("/symptom")
    public ResponseEntity<SymptomModel> saveSymptom(@RequestBody @Valid SymptomRecordDto symptomRecordDto) {
        SymptomModel symptomModel = new SymptomModel();
        BeanUtils.copyProperties(symptomRecordDto, symptomModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(symptomRepository.save(symptomModel));
    }

}