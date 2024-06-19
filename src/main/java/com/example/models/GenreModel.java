package com.example.models;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Uma classe que representa um Gênero.
 * Esta entidade é mapeada para a tabela "TB_GENRE" no banco de dados.
 * Cada gênero possui um ID único e um nome.
 * 
 * <p>Exemplo de uso:</p>
 * <pre>
 * {@code
 * GenreModel genero = new GenreModel();
 * genero.setName("Ficção Científica");
 * }
 * </pre>
 * 
 * @version 1.0
 * @since 2024-06-18
 */
@Entity
@Table(name = "TB_GENRE")
public class GenreModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    /**
     * Obtém o ID do gênero.
     * 
     * @return o ID do gênero
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do gênero.
     * 
     * @param id o ID a ser definido
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do gênero.
     * 
     * @return o nome do gênero
     */
    public String getName() {
        return this.name;
    }

    /**
     * Define o nome do gênero.
     * 
     * @param name o nome a ser definido
     */
    public void setName(String name) {
        this.name = name;
    }
}
