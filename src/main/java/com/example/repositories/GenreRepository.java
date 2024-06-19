package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.GenreModel;

/**
 * Interface de repositório para a entidade GenreModel, responsável por operações de persistência
 * e consulta relacionadas aos gêneros.
 * Utiliza o Spring Data JPA para implementar operações CRUD básicas.
 *
 * @version 1.0
 * @since 2024-06-18
 */
@Repository
public interface GenreRepository extends JpaRepository<GenreModel, Integer> {
}
