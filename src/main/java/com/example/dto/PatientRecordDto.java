package com.example.dto;

import java.util.Optional;

import com.example.models.AddressModel;

public record PatientRecordDto(String name, String motherName, String birthday,
                int genre, Optional<AddressModel> address, Optional<String> phoneNumber, Optional<String> email) {

}