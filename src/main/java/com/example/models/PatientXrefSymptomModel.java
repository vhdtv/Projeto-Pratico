package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_PATIENT_XREF_SYMPTOM")
public class PatientXrefSymptomModel implements Serializable {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "symptom_id", nullable = false)
    private SymptomModel symptom;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientModel patient;

    private String annotations;
    private int intensity;
    private int averageDays;

    @ManyToOne
    @JoinColumn(name = "attendance_registration_id", nullable = false)
    private ReportModel attendanceRegistration;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public SymptomModel getSymptom() {
        return symptom;
    }

    public void setSymptom(SymptomModel symptom) {
        this.symptom = symptom;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public String getAnnotations() {
        return annotations;
    }

    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public int getAverageDays() {
        return averageDays;
    }

    public void setAverageDays(int averageDays) {
        this.averageDays = averageDays;
    }

    public ReportModel getAttendanceRegistration() {
        return attendanceRegistration;
    }

    public void setAttendanceRegistration(ReportModel attendanceRegistration) {
        this.attendanceRegistration = attendanceRegistration;
    }
}
