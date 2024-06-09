package com.example.dto;

import jakarta.validation.constraints.NotBlank;

public record PatientRecordDto(@NotBlank String name, @NotBlank String motherName, @NotBlank String birthday,
        int genre, int address, String phoneNumber, String email) {

}