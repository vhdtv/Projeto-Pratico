package com.example.dto;

import jakarta.validation.constraints.NotBlank;

import java.sql.Date;

import com.example.models.AddressModel;
import com.example.models.GenreModel;

public record PatientRecordDto(@NotBlank String name, @NotBlank String motherName, @NotBlank Date birthday,
        @NotBlank GenreModel genre, AddressModel address, String phoneNumber, String email) {

}