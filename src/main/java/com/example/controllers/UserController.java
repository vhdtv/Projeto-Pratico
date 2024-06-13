package com.example.controllers;

import com.example.dto.AttendantRecordDto;
import com.example.models.AttendantModel;
import com.example.repositories.AttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AttendantRepository attendantRepository;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AttendantRecordDto attendantDto) {
        AttendantModel optionalAttendant = attendantRepository.findByEmailAndPasswordHash(attendantDto.email(), attendantDto.password()).orElse(null);
        
        if(optionalAttendant == null ){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalAttendant);
    }
}
