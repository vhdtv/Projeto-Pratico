package com.example.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.PatientModel;
import com.example.models.PriorityModel;
import com.example.models.ReportModel;

@Repository
public interface AttendanceRegistrationRepository extends JpaRepository<ReportModel, UUID> {
    public List<ReportModel> findAllByPatient(PatientModel patient);

    public List<ReportModel> findAllByPriorityEquals(PriorityModel priorityModel);
}
