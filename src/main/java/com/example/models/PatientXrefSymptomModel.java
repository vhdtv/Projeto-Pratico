package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Classe que representa a relação entre pacientes e sintomas.
 * Cada instância desta classe relaciona um paciente a um sintoma específico,
 * com anotações, intensidade do sintoma e média de dias de ocorrência.
 * 
 * @version 1.0
 * @since 2024-06-18
 */
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

    /**
     * Obtém o UUID único desta relação paciente-sintoma.
     * 
     * @return o UUID da relação
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Define o UUID desta relação paciente-sintoma.
     * 
     * @param uuid o UUID a ser definido
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Obtém o sintoma associado a esta relação.
     * 
     * @return o sintoma associado
     */
    public SymptomModel getSymptom() {
        return symptom;
    }

    /**
     * Define o sintoma associado a esta relação.
     * 
     * @param symptom o sintoma a ser definido
     */
    public void setSymptom(SymptomModel symptom) {
        this.symptom = symptom;
    }

    /**
     * Obtém o paciente associado a esta relação.
     * 
     * @return o paciente associado
     */
    public PatientModel getPatient() {
        return patient;
    }

    /**
     * Define o paciente associado a esta relação.
     * 
     * @param patient o paciente a ser definido
     */
    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    /**
     * Obtém as anotações relacionadas a esta relação.
     * 
     * @return as anotações associadas
     */
    public String getAnnotations() {
        return annotations;
    }

    /**
     * Define as anotações relacionadas a esta relação.
     * 
     * @param annotations as anotações a serem definidas
     */
    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    /**
     * Obtém a intensidade do sintoma nesta relação.
     * 
     * @return a intensidade do sintoma
     */
    public int getIntensity() {
        return intensity;
    }

    /**
     * Define a intensidade do sintoma nesta relação.
     * 
     * @param intensity a intensidade a ser definida
     */
    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    /**
     * Obtém a média de dias de ocorrência do sintoma nesta relação.
     * 
     * @return a média de dias de ocorrência
     */
    public int getAverageDays() {
        return averageDays;
    }

    /**
     * Define a média de dias de ocorrência do sintoma nesta relação.
     * 
     * @param average_days a média de dias de ocorrência a ser definida
     */
    public void setAverageDays(int averageDays) {
        this.averageDays = averageDays;
    }

    /**
     * Obtém o relatório de atendimento associado a esta relação.
     * 
     * @return o relatório de atendimento associado
     */
    public ReportModel getAttendanceRegistration() {
        return attendanceRegistration;
    }

    /**
     * Define o relatório de atendimento associado a esta relação.
     * 
     * @param attendance_registration o relatório de atendimento a ser definido
     */
    public void setAttendanceRegistration(ReportModel attendanceRegistration) {
        this.attendanceRegistration = attendanceRegistration;
    }
}
