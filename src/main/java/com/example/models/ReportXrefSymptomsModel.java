package com.example.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Classe que representa a relação entre um relatório e um sintoma.
 * Esta entidade é mapeada para a tabela "tb_report_xref_symptom" no banco de dados.
 * Cada relação possui um ID único, um relatório e um sintoma.
 * 
 * <p>Exemplo de uso:</p>
 * <pre>
 * {@code
 * ReportXrefSymptomsModel xref = new ReportXrefSymptomsModel();
 * xref.setReport(report);
 * xref.setSymptom(symptom);
 * }
 * </pre>
 * 
 * @version 1.0
 * @since 2024-06-18
 */
@Entity
@Table(name = "tb_report_xref_symptom")
public class ReportXrefSymptomsModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "fk_report")
    private ReportModel report;
    
    @ManyToOne
    @JoinColumn(name = "fk_symptom")
    private SymptomModel symptom;

    /**
     * Obtém o ID da relação.
     * 
     * @return o ID da relação
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID da relação.
     * 
     * @param id o ID a ser definido
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o sintoma associado à relação.
     * 
     * @return o sintoma associado
     */
    public SymptomModel getSymptom() {
        return symptom;
    }

    /**
     * Define o sintoma associado à relação.
     * 
     * @param symptom o sintoma a ser definido
     */
    public void setSymptom(SymptomModel symptom) {
        this.symptom = symptom;
    }

    /**
     * Obtém o relatório associado à relação.
     * 
     * @return o relatório associado
     */
    public ReportModel getReport() {
        return report;
    }

    /**
     * Define o relatório associado à relação.
     * 
     * @param report o relatório a ser definido
     */
    public void setReport(ReportModel report) {
        this.report = report;
    }
}
