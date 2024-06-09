package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

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