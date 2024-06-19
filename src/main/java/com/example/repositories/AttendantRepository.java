package com.example.repositories;

import com.example.models.AttendantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Interface de repositório para a entidade AttendantModel, responsável por operações de persistência
 * e consulta relacionadas aos atendentes.
 * Utiliza o Spring Data JPA para implementar operações CRUD básicas e consultas personalizadas.
 *
 * @version 1.0
 * @since 2024-06-18
 */
@Repository
public interface AttendantRepository extends JpaRepository<AttendantModel, UUID> {

    /**
     * Busca um atendente pelo email e senha fornecidos.
     *
     * @param email    O email do atendente a ser encontrado.
     * @param password A senha do atendente a ser verificada.
     * @return Um Optional contendo o atendente correspondente ao email e senha fornecidos, se encontrado.
     */
    Optional<AttendantModel> findByEmailAndPassword(String email, String password);

    Optional<AttendantModel> findByUsername(String username);
}
