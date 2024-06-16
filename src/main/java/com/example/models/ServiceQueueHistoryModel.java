package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_SERVICE_QUEUE_HISTORY")
public class ServiceQueueHistoryModel implements Serializable {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientModel patient;

    @ManyToOne
    @JoinColumn(name = "attendance_registration_id", nullable = false)
    private ReportModel attendance_registration;

    private Date arrival_date;
    private Date departure_date;

    @ManyToOne
    @JoinColumn(name = "priority_id", nullable = false)
    private PriorityModel priority;

    // Getters and Setters
}
