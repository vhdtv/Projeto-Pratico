package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_GENRE")
public class GenreModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}