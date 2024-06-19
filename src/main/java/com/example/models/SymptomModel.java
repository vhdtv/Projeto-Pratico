package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

/**
 * Classe que representa um sintoma em um sistema de gestão de saúde.
 * Cada instância desta classe contém informações sobre um sintoma específico,
 * incluindo nome, peso (importância relativa) e os relatórios que mencionam
 * este sintoma.
 * 
 * @version 1.0
 * @since 2024-06-18
 */
@Entity
@Table(name = "TB_SYMPTOM")
public class SymptomModel implements Serializable {
    @Id
    @Column(unique = true)
    private UUID uuid;

    @Column(length = 100)
    private String name;

    private int weight;

    @OneToMany(mappedBy = "symptom")
    private Set<ReportXrefSymptomsModel> reports;

    /**
     * Obtém a lista de relatórios associados a este sintoma.
     * 
     * @return a lista de relatórios associados
     */
    public Set<ReportXrefSymptomsModel> getReports() {
        return reports;
    }

    /**
     * Define a lista de relatórios associados a este sintoma.
     * 
     * @param reports a lista de relatórios a ser definida
     */
    public void setReports(Set<ReportXrefSymptomsModel> reports) {
        this.reports = reports;
    }

    /**
     * Obtém o UUID único deste sintoma.
     * 
     * @return o UUID do sintoma
     */

    public UUID getUuid() {
        return uuid;
    }

    public void addReport(ReportXrefSymptomsModel report) {
        this.reports.add(report);
    }

    /**
     * Define o UUID deste sintoma.
     * 
     * @param uuid o UUID a ser definido
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Obtém o nome deste sintoma.
     * 
     * @return o nome do sintoma
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome deste sintoma.
     * 
     * @param name o nome a ser definido
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o peso (importância relativa) deste sintoma.
     * 
     * @return o peso do sintoma
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Define o peso (importância relativa) deste sintoma.
     * 
     * @param weight o peso a ser definido
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Construtor padrão da classe SymptomModel.
     * Inicializa o UUID do sintoma com um valor único.
     */
    public SymptomModel() {
        super();
        this.uuid = UUID.randomUUID();
    }
}
