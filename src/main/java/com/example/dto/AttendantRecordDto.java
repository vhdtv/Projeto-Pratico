package com.example.dto;

import jakarta.validation.constraints.NotBlank;

public record AttendantRecordDto(@NotBlank String email, @NotBlank String password) {

}