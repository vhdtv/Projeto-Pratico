package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.PriorityModel;

/**
 * Interface de repositório para a entidade PriorityModel, responsável por operações de persistência
 * e consulta relacionadas às prioridades.
 * Utiliza o Spring Data JPA para implementar operações CRUD básicas.
 *
 * @version 1.0
 * @since 2024-06-18
 */
@Repository
public interface PriorityRepository extends JpaRepository<PriorityModel, Integer> {
}
