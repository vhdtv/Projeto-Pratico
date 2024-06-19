package com.example.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.models.PatientModel;
import com.example.models.SymptomModel;

public class PatientCreationDto {
    PatientModel patient;

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    private List<SymptomModel> symptoms = new ArrayList<>();
    private List<SymptomXrefHandlerDto> xSymptoms = new ArrayList<>();

    public List<SymptomModel> getSymptoms() {
        return symptoms;
    }

    public void addSymptom(SymptomModel symptom) {
        this.symptoms.add(symptom);
    }

    public List<SymptomXrefHandlerDto> getXSymptoms() {
        return xSymptoms;
    }

    public void addXSymptom(SymptomXrefHandlerDto entry) {
        this.xSymptoms.add(entry);
    }
}
