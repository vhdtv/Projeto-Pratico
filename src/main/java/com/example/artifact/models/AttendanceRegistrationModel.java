package com.example.artifact.models;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "TB_ATTENDANCE_REGISTRATION")
public class AttendanceRegistrationModel implements Serializable {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientModel patient;

    @ManyToOne
    @JoinColumn(name = "attendant_id", nullable = false)
    private AttendantModel attendant;

    private Date birthday;
    private String annotations;

    @ManyToOne
    @JoinColumn(name = "priority_id", nullable = false)
    private PriorityModel priority;

    // Getters and Setters
}