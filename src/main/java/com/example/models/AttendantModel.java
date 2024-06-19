package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Uma classe que representa um Atendente.
 * Esta entidade é mapeada para a tabela "TB_ATTENDANT" no banco de dados.
 * Cada atendente possui um UUID único, nome, nome de usuário, senha, email, número de telefone e especialidade.
 * 
 * <p>Exemplo de uso:</p>
 * <pre>
 * {@code
 * AttendantModel atendente = new AttendantModel();
 * atendente.setName("João Silva");
 * atendente.setUsername("joaosilva");
 * atendente.setPassword("senhaSegura123");
 * atendente.setEmail("joao.silva@example.com");
 * atendente.setPhone_number("123456789");
 * atendente.setSpeciality("Cardiologia");
 * }
 * </pre>
 * 
 * @version 1.0
 * @since 2024-06-18
 */
@Entity
@Table(name = "TB_ATTENDANT")
public class AttendantModel implements Serializable {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String name;

    private String username;

    private String password;

    private String email;

    private String phone_number;

    private String speciality;

    /**
     * Obtém o UUID do atendente.
     * 
     * @return o UUID
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Define o UUID do atendente.
     * 
     * @param uuid o UUID a ser definido
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Obtém o nome do atendente.
     * 
     * @return o nome
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do atendente.
     * 
     * @param name o nome a ser definido
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o nome de usuário do atendente.
     * 
     * @return o nome de usuário
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define o nome de usuário do atendente.
     * 
     * @param username o nome de usuário a ser definido
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtém a senha do atendente.
     * 
     * @return a senha
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Define a senha do atendente.
     * 
     * @param password a senha a ser definida
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtém o email do atendente.
     * 
     * @return o email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do atendente.
     * 
     * @param email o email a ser definido
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o número de telefone do atendente.
     * 
     * @return o número de telefone
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * Define o número de telefone do atendente.
     * 
     * @param phone_number o número de telefone a ser definido
     */
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * Obtém a especialidade do atendente.
     * 
     * @return a especialidade
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * Define a especialidade do atendente.
     * 
     * @param speciality a especialidade a ser definida
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
