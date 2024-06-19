package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.PatientXrefSymptomModel;

@Repository
public interface PatientXrefSymptomRepository extends JpaRepository<PatientXrefSymptomModel, Integer> {
}