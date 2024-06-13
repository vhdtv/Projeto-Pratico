package com.example.repositories;

import com.example.models.AttendantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AttendantRepository extends JpaRepository<AttendantModel, UUID> {
    Optional<AttendantModel> findByEmailAndPasswordHash(String email, String password_hash);
}
