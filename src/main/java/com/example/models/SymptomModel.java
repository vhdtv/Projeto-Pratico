package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_SYMPTOM")
public class SymptomModel implements Serializable {
    @Id
    @Column(unique = true)
    private UUID uuid;
    private String name;
    private int weight;
    @OneToMany(mappedBy = "symptom")
    private Set<ReportXrefSymptomsModel> reports;

    public Set<ReportXrefSymptomsModel> getReports() {
        return reports;
    }

    public void setReports(Set<ReportXrefSymptomsModel> reports) {
        this.reports = reports;
    }

    public void addReport(ReportXrefSymptomsModel report) {
        this.reports.add(report);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public SymptomModel() {
        super();
        this.uuid = UUID.randomUUID();
    }

}