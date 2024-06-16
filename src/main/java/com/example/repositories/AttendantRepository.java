package com.example.repositories;

import com.example.models.AttendantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttendantRepository extends JpaRepository<AttendantModel, UUID> {
    Optional<AttendantModel> findByEmailAndPassword(String email, String password);
}
