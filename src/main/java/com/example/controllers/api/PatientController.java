package com.example.controllers.api;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AddressRecordDto;
import com.example.dto.PatientPatchRecordDto;
import com.example.dto.PatientRecordDto;
import com.example.models.AddressModel;
import com.example.models.GenreModel;
import com.example.models.PatientModel;
import com.example.repositories.AddressRepository;
import com.example.repositories.GenreRepository;
import com.example.repositories.PatientRepository;

import jakarta.validation.Valid;

@RestController
public class PatientController {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    AddressRepository addressRepository;

    @PostMapping("/patient")
    public ResponseEntity<PatientModel> save(@RequestBody @Valid PatientRecordDto patientRecordDto) {
        PatientModel patientModel = new PatientModel();
        BeanUtils.copyProperties(patientRecordDto, patientModel);

        patientModel.setBirthday(this.generateBirthdayValue(patientRecordDto.birthday()));
        GenreModel genre = genreRepository.findById(patientRecordDto.genre()).orElse(null);
        if (genre == null)
            throw new Error("Genre was not found, received: " + patientRecordDto.genre());
        patientModel.setGenre(genre);
        AddressModel patientAddress = new AddressModel();
        if (patientRecordDto.address() != null) {
            BeanUtils.copyProperties(patientRecordDto.address().get(), patientAddress);
            patientModel.setId_address(patientAddress);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(patientRepository.save(patientModel));
    }

    @PatchMapping("/patient/{id}")
    public ResponseEntity<?> patch(@PathVariable("id") UUID uuid,
            @RequestBody PatientPatchRecordDto updates) {
        PatientModel patient = patientRepository.findById(uuid).orElse(null);
        if (null == patient)
            throw new Error("Patient was not found(error-number-" + uuid + ")");

        if (!updates.name().isEmpty()) {
            patient.setName(updates.name().get());
        }
        if (!updates.motherName().isEmpty()) {
            patient.setMotherName(updates.motherName().get());
        }
        if (!updates.birthday().isEmpty()) {
            patient.setBirthday(this.generateBirthdayValue(updates.birthday().get()));
        }
        if (!updates.genre().isEmpty()) {
            patient.setGenre(genreRepository.findById(updates.genre().get()).get());
        }
        if (!updates.address().isEmpty()) {
            AddressModel addressModel = new AddressModel();
            BeanUtils.copyProperties(updates.address().get(), addressModel);
            patient.setId_address(addressModel);
        }
        if (!updates.phoneNumber().isEmpty()) {
            patient.setPhoneNumber(updates.phoneNumber().get());
        }
        if (!updates.email().isEmpty()) {
            patient.setEmail(updates.email().get());
        }
        return ResponseEntity.status(HttpStatus.OK).body(patientRepository.save(patient));
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