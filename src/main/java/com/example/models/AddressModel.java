package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ADDRESS")
public class AddressModel implements Serializable {
    private static final long serialVersionUID = 1L;

    public AddressModel() {
        super();
        this.id = UUID.randomUUID();
    }

    public AddressModel(String firstLine, String houseNumber, String residenceType, String secondLine, String city,
            String state) {
        super();
        this.setResidenceType(firstLine);
        this.setHouseNumber(houseNumber);
        this.setSecondLine(residenceType);
        this.setCity(secondLine);
        this.setState(city);
        this.setFirstLine(state);
        this.id = UUID.randomUUID();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "first_line")
    private String firstLine;
    @Column(name = "house_number")
    private String houseNumber;
    @Column(name = "residence_type")
    private String residenceType;
    @Column(name = "second_line")
    private String secondLine; // acts like the neighborhood
    private String city;
    private String state;
    @Column(name = "postal_code")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }
}