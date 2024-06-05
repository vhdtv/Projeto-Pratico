package com.example.artifact.controllers;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.artifact.dto.GenreRecordDto;
import com.example.artifact.models.GenreModel;
import com.example.artifact.repositories.GenreRepository;

import jakarta.validation.Valid;

@RestController
public class GenreController {
    @Autowired
    GenreRepository genreRepository;

    /***
     * Metodo POST para criação de um novo gênero
     * 
     * @param genreRecordDto
     * @return
     */
    @PostMapping("/genre")
    public ResponseEntity<GenreModel> saveGenre(@RequestBody @Valid GenreRecordDto genreRecordDto) {
        GenreModel genreModel = new GenreModel();
        BeanUtils.copyProperties(genreRecordDto, genreModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(genreRepository.save(genreModel));
    }

    @GetMapping("/genre")
    public ResponseEntity<Optional<GenreModel>> findGenre() {
        return ResponseEntity.status(HttpStatus.OK).body(genreRepository.findById(1));
    }
}