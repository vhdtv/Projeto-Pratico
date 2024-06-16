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
    private int average_days;

    @ManyToOne
    @JoinColumn(name = "attendance_registration_id", nullable = false)
    private ReportModel attendance_registration;

    // Getters and Setters
}
