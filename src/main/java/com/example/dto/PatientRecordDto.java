package com.example.dto;

import java.util.List;
import java.util.Optional;

import com.example.models.AddressModel;
import com.example.models.ComorbidityModel;
import com.example.models.GenreModel;

public record PatientRecordDto(String name, String motherName, Optional<String> fatherName, String birthday,
        GenreModel genre, Optional<ComorbidityModel> comorbidities, Optional<AddressModel> address,
        Optional<List<SymptomXrefHandlerDto>> symptoms,
        Optional<String> phoneNumber, Optional<String> email) {

}