package com.example.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PatientRecordDto;
import com.example.models.GenreModel;
import com.example.models.PatientModel;
import com.example.repositories.GenreRepository;
import com.example.repositories.PatientRepository;

import jakarta.validation.Valid;

@RestController
public class PatientController {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    GenreRepository genreRepository;

    @PostMapping("/patient")
    public ResponseEntity<PatientModel> savePatient(@RequestBody @Valid PatientRecordDto patientRecordDto) {
        PatientModel patientModel = new PatientModel(UUID.randomUUID());
        BeanUtils.copyProperties(patientRecordDto, patientModel);

        patientModel.setBirthday(this.generateBirthdayValue(patientRecordDto.birthday()));
        GenreModel genre = genreRepository.findById(patientRecordDto.genre()).orElse(null);
        if (genre == null)
            throw new Error("Genre was not found, received: " + patientRecordDto.genre());
        patientModel.setGenre(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientRepository.save(patientModel));
    }

    private Date generateBirthdayValue(String inputDate) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = new java.util.Date();
        try {
            date = dateFormatter.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date(date.getTime());
    }
}