package com.example.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.SymptomModel;

public interface SymptomRepository extends JpaRepository<SymptomModel,UUID> {


    
} 
