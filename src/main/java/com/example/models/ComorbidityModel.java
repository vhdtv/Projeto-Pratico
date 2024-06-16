package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Entidade que representa uma comorbidade
 * uuid -> identificador
 * name -> nome da comorbidade
 * multiply_factor -> numero que multiplica o valor de alguns sintomas
 */
@Entity
@Table(name = "TB_COMORBIDITY")
public class ComorbidityModel implements Serializable {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;
    private double multiplyFactor;

    public double getMultiplyFactor() {
        return multiplyFactor;
    }

    public void setMultiplyFactor(double multiplyFactor) {
        this.multiplyFactor = multiplyFactor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}