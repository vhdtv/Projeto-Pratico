package com.example.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_PATIENTS")
public class PatientModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String motherName;
    @Column(length = 50)
    private String fatherName;
    private Date birthday;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_genre")
    private GenreModel genre;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_model")
    private AddressModel address;
    @Column(length = 20)
    private String phone_number;
    @Column(length = 50)
    private String email;

    public PatientModel() {
        super();
    }

    public PatientModel(UUID id) {
        super();
        this.setId(id);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherName() {
        return this.motherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherName() {
        return this.fatherName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setGenre(GenreModel genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre.getName();
    }

    public void setId_address(AddressModel address) {
        this.address = address;
    }

    public AddressModel getAddress() {
        return this.address;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPhone_number() {
        return this.phone_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}