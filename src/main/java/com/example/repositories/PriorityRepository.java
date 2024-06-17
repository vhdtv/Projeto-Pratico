package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.PriorityModel;

@Repository
public interface PriorityRepository extends JpaRepository<PriorityModel, Integer> {
   
}