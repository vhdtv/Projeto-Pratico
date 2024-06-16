package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_SERVICE_QUEUE")
public class ServiceQueueModel implements Serializable {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientModel patient;
    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private ReportModel report;
    private Date arrival_date;
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "priority_id", nullable = false)
    private PriorityModel priority;
    private Long score;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public ReportModel getReport() {
        return report;
    }

    public void setReport(ReportModel report) {
        this.report = report;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public PriorityModel getPriority() {
        return priority;
    }

    public void setPriority(PriorityModel priority) {
        this.priority = priority;
    }

}
