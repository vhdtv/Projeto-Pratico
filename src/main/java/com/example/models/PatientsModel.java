package com.example.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_PATIENTS")
public class PatientsModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String mother_name;
    @Column(length = 50)
    private String father_name;
    private Date birthday;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GenreModel.id")
    private GenreModel genre;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AddressModel.id")
    private AddressModel address;
    @Column(length = 20)
    private String phone_number;
    @Column(length = 50)
    private String email;

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

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getMother_name() {
        return this.mother_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getFather_name() {
        return this.father_name;
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

    public GenreModel getGenre() {
        return this.genre;
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