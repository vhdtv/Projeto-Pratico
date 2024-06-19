package com.example.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.AddressModel;

/**
 * Interface de repositório para a entidade AddressModel.
 * Esta interface utiliza o Spring Data JPA para fornecer operações CRUD básicas
 * e consultas personalizadas para a entidade AddressModel.
 * 
 * @version 1.0
 * @since 2024-06-18
 */
@Repository
public interface AddressRepository extends JpaRepository<AddressModel, UUID> {

}
