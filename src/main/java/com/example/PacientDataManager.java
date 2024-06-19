package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Classe principal que inicia a aplicação Patient Data Manager.
 * Configura o Spring Boot para escanear e configurar adequadamente os componentes da aplicação.
 *
 * @version 1.0
 * @since 2024-06-18
 */
@SpringBootApplication(scanBasePackages = { "com.example" })
@EntityScan("com.example.models")
public class PacientDataManager {

    /**
     * Método principal que inicia a aplicação Spring Boot.
     *
     * @param args Argumentos de linha de comando (não são usados neste exemplo).
     */
    public static void main(String[] args) {
        SpringApplication.run(PacientDataManager.class, args);
    }

}
