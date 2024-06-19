package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Classe que representa um relatório.
 * Esta entidade é mapeada para a tabela "tb_report" no banco de dados.
 * Cada relatório possui um UUID único, um paciente, um atendente, uma prioridade,
 * uma lista de sintomas, data de criação, data de atualização, uma fila de serviço e anotações.
 * 
 * <p>Exemplo de uso:</p>
 * <pre>
 * {@code
 * ReportModel report = new ReportModel();
 * report.setPatient(patient);
 * report.setAttendant(attendant);
 * report.setPriority(priority);
 * report.setCreatedAt(new Date());
 * report.setAnnotations("Paciente estável");
 * }
 * </pre>
 * 
 * @version 1.0
 * @since 2024-06-18
 */
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

    private Date createdAt;

    private Date updatedAt;

    @OneToOne
    @JoinColumn(name = "queue_id", referencedColumnName = "id")
    private ServiceQueueModel queue;

    private String annotations;

    /**
     * Obtém a data de atualização do relatório.
     * 
     * @return a data de atualização
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Define a data de atualização do relatório.
     * 
     * @param updatedAt a data de atualização a ser definida
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Obtém o UUID do relatório.
     * 
     * @return o UUID do relatório
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Define o UUID do relatório.
     * 
     * @param uuid o UUID a ser definido
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Obtém o paciente associado ao relatório.
     * 
     * @return o paciente associado
     */
    public PatientModel getPatient() {
        return patient;
    }

    /**
     * Define o paciente associado ao relatório.
     * 
     * @param patient o paciente a ser definido
     */
    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    /**
     * Obtém o atendente associado ao relatório.
     * 
     * @return o atendente associado
     */
    public AttendantModel getAttendant() {
        return attendant;
    }

    /**
     * Define o atendente associado ao relatório.
     * 
     * @param attendant o atendente a ser definido
     */
    public void setAttendant(AttendantModel attendant) {
        this.attendant = attendant;
    }

    /**
     * Obtém a data de criação do relatório.
     * 
     * @return a data de criação
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Define a data de criação do relatório.
     * 
     * @param createdAt a data de criação a ser definida
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Obtém as anotações do relatório.
     * 
     * @return as anotações do relatório
     */
    public String getAnnotations() {
        return annotations;
    }

    /**
     * Define as anotações do relatório.
     * 
     * @param annotations as anotações a serem definidas
     */
    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    /**
     * Obtém a prioridade do relatório.
     * 
     * @return a prioridade do relatório
     */
    public PriorityModel getPriority() {
        return priority;
    }

    /**
     * Define a prioridade do relatório.
     * 
     * @param priority a prioridade a ser definida
     */
    public void setPriority(PriorityModel priority) {
        this.priority = priority;
    }

    /**
     * Obtém a lista de sintomas associados ao relatório.
     * 
     * @return a lista de sintomas
     */
    public List<SymptomModel> getSymptoms() {
        List<SymptomModel> result = new ArrayList<SymptomModel>();
        for (ReportXrefSymptomsModel item : this.symptoms)
            result.add(item.getSymptom());
        return result;
    }

    /**
     * Define a lista de sintomas associados ao relatório.
     * 
     * @param symptoms a lista de sintomas a serem definidas
     */
    public void setSymptoms(Set<ReportXrefSymptomsModel> symptoms) {
        this.symptoms = symptoms;
    }

    /**
     * Obtém a fila de serviço associada ao relatório.
     * 
     * @return a fila de serviço associada
     */
    public ServiceQueueModel getQueue() {
        return queue;
    }

    /**
     * Define a fila de serviço associada ao relatório.
     * 
     * @param queue a fila de serviço a ser definida
     */
    public void setQueue(ServiceQueueModel queue) {
        this.queue = queue;
    }
}
