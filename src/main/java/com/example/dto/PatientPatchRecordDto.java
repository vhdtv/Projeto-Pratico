package com.example.dto;

import java.util.Optional;

import com.example.models.AddressModel;

public record PatientPatchRecordDto(Optional<String> name, Optional<String> motherName, Optional<String> birthday,
        Optional<Integer> genre, Optional<AddressModel> address, Optional<String> phoneNumber, Optional<String> email) {
}