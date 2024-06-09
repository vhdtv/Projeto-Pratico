package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ATTENDANT")
public class AttendantModel implements Serializable {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;
    private String username;
    private String password_hash;
    private String email;
    private String phone_number;
    private String speciality;

}