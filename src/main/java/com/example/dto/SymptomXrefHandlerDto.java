package com.example.dto;

import com.example.models.SymptomModel;
import java.util.Optional;

public class SymptomXrefHandlerDto {
    SymptomModel symptomModel;

    /** Inherited from PatientXrefSymptomModel */
    Optional<String> annotations;
    Optional<Integer> intensity;
    Optional<Integer> averageDays;

    public Optional<String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Optional<String> annotations) {
        this.annotations = annotations;
    }

    public Optional<Integer> getIntensity() {
        return intensity;
    }

    public void setIntensity(Optional<Integer> intensity) {
        this.intensity = intensity;
    }

    public SymptomModel getSymptomModel() {
        return symptomModel;
    }

    public void setSymptomModel(SymptomModel symptomModel) {
        this.symptomModel = symptomModel;
    }

    public Optional<Integer> getAverageDays() {
        return averageDays;
    }

    public void setAverageDays(Optional<Integer> averageDays) {
        this.averageDays = averageDays;
    }

}