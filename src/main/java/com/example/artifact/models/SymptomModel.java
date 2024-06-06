package com.example.artifact.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_SYMPTOM")
public class SymptomModel implements Serializable {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;
    private int weight;
}