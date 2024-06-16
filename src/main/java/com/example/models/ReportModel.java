package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.core.annotation.Order;

@Entity
@Table(name = "tb_report")
public class ReportModel implements Serializable {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "fk_patient", nullable = false)
    private PatientModel patient;

    @ManyToOne
    @JoinColumn(name = "fk_attendant", nullable = false)
    private AttendantModel attendant;

    @ManyToOne
    @JoinColumn(name = "fk_priority", nullable = false)
    private PriorityModel priority;

    @OneToMany(mappedBy = "report")
    @OrderBy("fk_symptom")
    private Set<ReportXrefSymptomsModel> symptoms;

    @Column
    private Date createdAt;

    @Column
    private String annotations;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public AttendantModel getAttendant() {
        return attendant;
    }

    public void setAttendant(AttendantModel attendant) {
        this.attendant = attendant;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getAnnotations() {
        return annotations;
    }

    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    public PriorityModel getPriority() {
        return priority;
    }

    public void setPriority(PriorityModel priority) {
        this.priority = priority;
    }

    public List<SymptomModel> getSymptoms() {
        List<SymptomModel> result = new ArrayList<SymptomModel>();
        for (ReportXrefSymptomsModel item : this.symptoms)
            result.add(item.getSymptom());
        return result;
    }

    public void setSymptoms(Set<ReportXrefSymptomsModel> symptoms) {
        this.symptoms = symptoms;
    }
}