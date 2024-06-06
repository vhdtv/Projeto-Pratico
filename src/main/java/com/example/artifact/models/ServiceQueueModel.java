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
@Table(name = "TB_SERVICE_QUEUE")
public class ServiceQueueModel implements Serializable {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientModel patient;

    @ManyToOne
    @JoinColumn(name = "attendance_registration_id", nullable = false)
    private AttendanceRegistrationModel attendance_registration;

    private Date arrival_date;

    @ManyToOne
    @JoinColumn(name = "priority_id", nullable = false)
    private PriorityModel priority;

}
