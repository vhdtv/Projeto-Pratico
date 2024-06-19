package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.ReportModel;
import com.example.models.ReportXrefSymptomsModel;

@Repository
public interface ReportXrefSymptomsRepository extends JpaRepository<ReportXrefSymptomsModel, Integer> {
   public List<ReportXrefSymptomsModel>  findAllByReportEquals(ReportModel reportModel);
}
