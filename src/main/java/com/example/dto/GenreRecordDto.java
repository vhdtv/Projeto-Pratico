package com.example.dto;

import jakarta.validation.constraints.NotBlank;

public record GenreRecordDto(@NotBlank String name) {

}