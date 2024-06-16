package com.example.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_report_xref_symptom")
public class ReportXrefSymptomsModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "fk_report")
    private ReportModel report;
    @ManyToOne
    @JoinColumn(name = "fk_symptom")
    private SymptomModel symptom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SymptomModel getSymptom() {
        return symptom;
    }

    public void setSymptom(SymptomModel symptom) {
        this.symptom = symptom;
    }

    public ReportModel getAttendanceRegistration() {
        return report;
    }

    public void setAttendanceRegistration(ReportModel report) {
        this.report = report;
    }

}