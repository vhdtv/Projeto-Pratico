package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.ReportModel;

@Repository
public interface ReportRepository extends JpaRepository<ReportModel, Integer> {

}