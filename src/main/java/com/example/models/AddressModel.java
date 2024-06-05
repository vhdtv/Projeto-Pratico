package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ADDRESS")
public class AddressModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String first_line;
    private String house_number;
    private String residence_type;
    private String second_line; // acts like the neighborhood
    private String city;
    private String state;

}