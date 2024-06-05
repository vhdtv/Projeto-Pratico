package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GenreRecordDto(@NotNull int id, @NotBlank String name) {

}