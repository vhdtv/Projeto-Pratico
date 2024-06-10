package com.example.dto;

import jakarta.validation.constraints.NotBlank;

public record SymptomRecordDto(@NotBlank String name, int weight) {

}
