package com.example.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.PriorityModel;
import com.example.models.ReportModel;

/**
 * Interface de repositório para a entidade ReportModel, responsável por operações de persistência
 * e consulta relacionadas aos registros de atendimento.
 * Utiliza o Spring Data JPA para implementar operações CRUD básicas e consultas personalizadas.
 *
 * @version 1.0
 * @since 2024-06-18
 */
@Repository
public interface AttendanceRegistrationRepository extends JpaRepository<ReportModel, UUID> {

    /**
     * Retorna uma lista de registros de atendimento filtrados por uma prioridade específica.
     *
     * @param priorityModel A prioridade pela qual os registros de atendimento devem ser filtrados.
     * @return Uma lista de registros de atendimento que correspondem à prioridade fornecida.
     */
    public List<ReportModel> findAllByPriorityEquals(PriorityModel priorityModel);
}
