package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Uma classe que representa a prioridade.
 * Esta entidade é mapeada para a tabela "TB_PRIORITY" no banco de dados.
 * Cada prioridade possui um ID único, uma cor e uma descrição.
 * 
 * <p>Exemplo de uso:</p>
 * <pre>
 * {@code
 * PriorityModel prioridade = new PriorityModel();
 * prioridade.setColor("Vermelho");
 * prioridade.setDescription("Alta prioridade");
 * }
 * </pre>
 * 
 * @version 1.0
 * @since 2024-06-18
 */
@Entity
@Table(name = "TB_PRIORITY")
public class PriorityModel implements Serializable {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String color;

    private String description;

    /**
     * Obtém a descrição da prioridade.
     * 
     * @return a descrição da prioridade
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição da prioridade.
     * 
     * @param description a descrição a ser definida
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtém a cor da prioridade.
     * 
     * @return a cor da prioridade
     */
    public String getColor() {
        return color;
    }

    /**
     * Define a cor da prioridade.
     * 
     * @param color a cor a ser definida
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtém o ID da prioridade.
     * 
     * @return o ID da prioridade
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID da prioridade.
     * 
     * @param id o ID a ser definido
     */
    public void setId(int id) {
        this.id = id;
    }
}
