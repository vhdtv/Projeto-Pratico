package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.AddressModel;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Integer> {
}
