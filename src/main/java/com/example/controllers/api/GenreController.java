package com.example.controllers.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.GenreRecordDto;
import com.example.models.GenreModel;
import com.example.repositories.GenreRepository;

import jakarta.validation.Valid;

@RestController
public class GenreController {
    @Autowired
    GenreRepository genreRepository;

    @PostMapping("/genre")
    public ResponseEntity<GenreModel> saveGenre(@RequestBody @Valid GenreRecordDto genreRecordDto) {
        GenreModel genreModel = new GenreModel();
        genreModel.setId((int) this.genreRepository.count() + 1);
        BeanUtils.copyProperties(genreRecordDto, genreModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(genreRepository.save(genreModel));
    }

    @GetMapping("/genre")
    public ResponseEntity<List<GenreModel>> findGenre() {
        return ResponseEntity.status(HttpStatus.OK).body(genreRepository.findAll());
    }
}