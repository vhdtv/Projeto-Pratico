package com.example.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.PatientModel;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, UUID> {
}
