package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.SymptomModel;

import java.util.UUID;

/**
 * Interface de repositório para a entidade SymptomModel, responsável por operações de persistência
 * e consulta relacionadas aos sintomas.
 * Utiliza o Spring Data JPA para implementar operações CRUD básicas.
 *
 * @version 1.0
 * @since 2024-06-18
 */
public interface SymptomRepository extends JpaRepository<SymptomModel, UUID> {
}
