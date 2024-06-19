package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.PatientModel;

import java.util.UUID;

/**
 * Interface de repositório para a entidade PatientModel, responsável por operações de persistência
 * e consulta relacionadas aos pacientes.
 * Utiliza o Spring Data JPA para implementar operações CRUD básicas.
 *
 * @version 1.0
 * @since 2024-06-18
 */
@Repository
public interface PatientRepository extends JpaRepository<PatientModel, UUID> {
}
