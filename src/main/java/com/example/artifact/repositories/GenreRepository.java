package com.example.artifact.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.artifact.models.GenreModel;

@Repository
public interface GenreRepository extends JpaRepository<GenreModel, Integer> {
}
