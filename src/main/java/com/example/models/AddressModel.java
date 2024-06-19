package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Uma classe que representa um Endereço.
 * Esta entidade é mapeada para a tabela "TB_ADDRESS" no banco de dados.
 * Cada endereço consiste em vários campos, incluindo primeira linha, número da casa,
 * tipo de residência, segunda linha (bairro), cidade, estado e código postal.
 * 
 * <p>Cada objeto AddressModel é identificado por um UUID único.</p>
 * 
 * <p>Exemplo de uso:</p>
 * <pre>
 * {@code
 * AddressModel endereco = new AddressModel("123 Rua Principal", "45B", "Apartamento", "Centro", "Springfield", "IL");
 * endereco.setPostalCode("62704");
 * }
 * </pre>
 * 
 * @version 1.0
 * @since 2023-06-18
 */
@Entity
@Table(name = "TB_ADDRESS")
public class AddressModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Construtor padrão que inicializa o endereço com um novo UUID.
     */
    public AddressModel() {
        super();
        this.id = UUID.randomUUID();
    }

    /**
     * Construtor com parâmetros para inicializar todos os campos do endereço.
     * 
     * @param firstLine A primeira linha do endereço (por exemplo, nome e número da rua)
     * @param houseNumber O número da casa
     * @param residenceType O tipo de residência (por exemplo, apartamento, casa)
     * @param secondLine A segunda linha do endereço (por exemplo, bairro)
     * @param city A cidade do endereço
     * @param state O estado do endereço
     */
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
    private String secondLine; // atua como o bairro

    private String city;

    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    /**
     * Obtém o código postal do endereço.
     * 
     * @return o código postal
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Define o código postal do endereço.
     * 
     * @param postalCode o código postal a ser definido
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Obtém o tipo de residência do endereço.
     * 
     * @return o tipo de residência
     */
    public String getResidenceType() {
        return residenceType;
    }

    /**
     * Define o tipo de residência do endereço.
     * 
     * @param residenceType o tipo de residência a ser definido
     */
    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

    /**
     * Obtém o número da casa do endereço.
     * 
     * @return o número da casa
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Define o número da casa do endereço.
     * 
     * @param houseNumber o número da casa a ser definido
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Obtém a segunda linha do endereço (bairro).
     * 
     * @return a segunda linha
     */
    public String getSecondLine() {
        return secondLine;
    }

    /**
     * Define a segunda linha do endereço (bairro).
     * 
     * @param secondLine a segunda linha a ser definida
     */
    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    /**
     * Obtém a cidade do endereço.
     * 
     * @return a cidade
     */
    public String getCity() {
        return city;
    }

    /**
     * Define a cidade do endereço.
     * 
     * @param city a cidade a ser definida
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Obtém o estado do endereço.
     * 
     * @return o estado
     */
    public String getState() {
        return state;
    }

    /**
     * Define o estado do endereço.
     * 
     * @param state o estado a ser definido
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Obtém a primeira linha do endereço (por exemplo, nome e número da rua).
     * 
     * @return a primeira linha
     */
    public String getFirstLine() {
        return firstLine;
    }

    /**
     * Define a primeira linha do endereço (por exemplo, nome e número da rua).
     * 
     * @param firstLine a primeira linha a ser definida
     */
    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }
}
