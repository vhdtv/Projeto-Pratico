package com.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record LoginRecordDto(@Email @NotEmpty(message = "Informe o email") String email,
        @NotEmpty(message = "Senha não informada") String password) {
}
