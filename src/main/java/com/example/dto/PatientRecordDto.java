package com.example.dto;

import java.util.Optional;

public record PatientRecordDto(String name, String motherName, String birthday,
        int genre, Optional<Integer> address, Optional<String> phoneNumber, Optional<String> email) {

}