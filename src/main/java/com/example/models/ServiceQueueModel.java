package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe que representa uma fila de serviço para pacientes.
 * Cada instância desta classe está associada a um paciente, um relatório,
 * uma prioridade e possui uma data de chegada e um estado de ativação.
 * 
 * @version 1.0
 * @since 2024-06-18
 */
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

    /**
     * Verifica se a fila de serviço está ativa.
     * 
     * @return true se a fila estiver ativa, false caso contrário
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Define o estado de ativação da fila de serviço.
     * 
     * @param active true para ativar a fila, false para desativar
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Obtém a pontuação associada à fila de serviço.
     * 
     * @return a pontuação da fila de serviço
     */
    public Long getScore() {
        return score;
    }

    /**
     * Define a pontuação associada à fila de serviço.
     * 
     * @param score a pontuação a ser definida
     */
    public void setScore(Long score) {
        this.score = score;
    }

    /**
     * Obtém o ID da fila de serviço.
     * 
     * @return o ID da fila de serviço
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID da fila de serviço.
     * 
     * @param id o ID a ser definido
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o paciente associado à fila de serviço.
     * 
     * @return o paciente associado à fila de serviço
     */
    public PatientModel getPatient() {
        return patient;
    }

    /**
     * Define o paciente associado à fila de serviço.
     * 
     * @param patient o paciente a ser definido
     */
    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    /**
     * Obtém o relatório associado à fila de serviço.
     * 
     * @return o relatório associado à fila de serviço
     */
    public ReportModel getReport() {
        return report;
    }

    /**
     * Define o relatório associado à fila de serviço.
     * 
     * @param report o relatório a ser definido
     */
    public void setReport(ReportModel report) {
        this.report = report;
    }

    /**
     * Obtém a data de chegada da fila de serviço.
     * 
     * @return a data de chegada da fila de serviço
     */
    public Date getArrival_date() {
        return arrival_date;
    }

    /**
     * Define a data de chegada da fila de serviço.
     * 
     * @param arrival_date a data de chegada a ser definida
     */
    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    /**
     * Obtém a prioridade associada à fila de serviço.
     * 
     * @return a prioridade associada à fila de serviço
     */
    public PriorityModel getPriority() {
        return priority;
    }

    /**
     * Define a prioridade associada à fila de serviço.
     * 
     * @param priority a prioridade a ser definida
     */
    public void setPriority(PriorityModel priority) {
        this.priority = priority;
    }
}
