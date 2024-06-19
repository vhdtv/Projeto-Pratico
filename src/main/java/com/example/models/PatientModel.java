package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

/**
 * Uma classe que representa um Paciente.
 * Esta entidade é mapeada para a tabela "TB_PATIENTS" no banco de dados.
 * Cada paciente possui um UUID único, nome, nome da mãe, nome do pai, data de
 * nascimento, gênero, comorbidades, endereço, número de telefone e email.
 * 
 * <p>
 * Exemplo de uso:
 * </p>
 * 
 * <pre>
 * {@code
 * PatientModel paciente = new PatientModel();
 * paciente.setName("Maria da Silva");
 * paciente.setMotherName("Ana da Silva");
 * paciente.setFatherName("João da Silva");
 * paciente.setBirthday(Date.valueOf("1980-05-15"));
 * paciente.setGenre(new GenreModel("Feminino"));
 * paciente.setAddress(new AddressModel("Rua Principal", "123", "Casa", "Centro", "Cidade", "Estado"));
 * paciente.setPhoneNumber("123456789");
 * paciente.setEmail("maria.silva@example.com");
 * }
 * </pre>
 * 
 * @version 1.0
 * @since 2024-06-18
 */
@Entity
@Table(name = "TB_PATIENTS")
public class PatientModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(unique = true)
    private UUID id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String motherName;

    @Column(length = 50)
    private String fatherName;

    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "fk_genre")
    private GenreModel genre;

    @OneToMany
    private List<ComorbidityModel> comorbidities;

    @ManyToOne
    @JoinColumn(name = "fk_address")
    private AddressModel address;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 50)
    private String email;

    /**
     * Construtor padrão que inicializa o UUID com um valor aleatório.
     */
    public PatientModel() {
        super();
        this.id = UUID.randomUUID();
    }

    /**
     * Define o UUID do paciente.
     * 
     * @param id o UUID a ser definido
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Obtém o UUID do paciente.
     * 
     * @return o UUID do paciente
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Define o nome do paciente.
     * 
     * @param name o nome a ser definido
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o nome do paciente.
     * 
     * @return o nome do paciente
     */
    public String getName() {
        return this.name;
    }

    /**
     * Define o nome da mãe do paciente.
     * 
     * @param motherName o nome da mãe a ser definido
     */
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    /**
     * Obtém o nome da mãe do paciente.
     * 
     * @return o nome da mãe do paciente
     */
    public String getMotherName() {
        return this.motherName;
    }

    /**
     * Define o nome do pai do paciente.
     * 
     * @param fatherName o nome do pai a ser definido
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    /**
     * Obtém o nome do pai do paciente.
     * 
     * @return o nome do pai do paciente
     */
    public String getFatherName() {
        return this.fatherName;
    }

    /**
     * Define a data de nascimento do paciente.
     * 
     * @param birthday a data de nascimento a ser definida
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Obtém a data de nascimento do paciente.
     * 
     * @return a data de nascimento do paciente
     */
    public Date getBirthday() {
        return this.birthday;
    }

    /**
     * Define o gênero do paciente.
     * 
     * @param genre o gênero a ser definido
     */
    public void setGenre(GenreModel genre) {
        this.genre = genre;
    }

    /**
     * Obtém o gênero do paciente.
     * 
     * @return o gênero do paciente
     */
    public GenreModel getGenre() {
        return this.genre;
    }

    /**
     * Define o endereço do paciente.
     * 
     * @param address o endereço a ser definido
     */
    public void setAddress(AddressModel address) {
        this.address = address;
    }

    /**
     * Obtém o endereço do paciente.
     * 
     * @return o endereço do paciente
     */
    public AddressModel getAddress() {
        return this.address;
    }

    /**
     * Define o número de telefone do paciente.
     * 
     * @param phoneNumber o número de telefone a ser definido
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Obtém o número de telefone do paciente.
     * 
     * @return o número de telefone do paciente
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Define o email do paciente.
     * 
     * @param email o email a ser definido
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o email do paciente.
     * 
     * @return o email do paciente
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Define as comorbidades do paciente.
     * 
     * @param comorbidities a lista de comorbidades a ser definida
     */
    public void setComorbidities(List<ComorbidityModel> comorbidities) {
        this.comorbidities = comorbidities;
    }

    /**
     * Obtém a lista de comorbidades do paciente.
     * 
     * @return a lista de comorbidades do paciente
     */
    public List<ComorbidityModel> getComorbidities() {
        return comorbidities;
    }
}
