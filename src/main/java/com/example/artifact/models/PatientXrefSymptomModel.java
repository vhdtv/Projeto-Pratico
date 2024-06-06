package com.example.artifact.models;

import java.io.Serializable;

import org.hibernate.validator.constraints.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
    private int average_days;

    @ManyToOne
    @JoinColumn(name = "attendance_registration_id", nullable = false)
    private AttendanceRegistrationModel attendance_registration;

    // Getters and Setters
}
