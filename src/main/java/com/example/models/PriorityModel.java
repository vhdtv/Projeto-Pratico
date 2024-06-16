package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_PRIORITY")
public class PriorityModel implements Serializable {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String color;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
