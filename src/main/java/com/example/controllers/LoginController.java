package com.example.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.dto.LoginRecordDto;
import com.example.models.AttendantModel;
import com.example.repositories.AttendantRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

/**
 * Controlador que lida com as operações de login.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    AttendantRepository attendantRepository;

    /**
     * Exibe o formulário
     *
     * @return o caminho para a visualização da página do login
     */
    @GetMapping("/login")
    public String loginForm(Model context) {
        context.addAttribute("user", new AttendantModel());
        return "pages/login";
    }

    @PostMapping("/login")
    public String loginAction(@Valid @ModelAttribute("user") LoginRecordDto loginRecordDto, HttpSession session) {
        Optional<AttendantModel> user = this.attendantRepository.findByEmailAndPassword(loginRecordDto.email(),
                loginRecordDto.password());
        if (user.isEmpty()) {
            return "redirect:login";
        }
        user.ifPresent(attendant -> session.setAttribute("pacienteNome", attendant.getName()));
        return "redirect:dashboard";
    }

    /**
     * Lida com as exceções
     *
     *
     * @return volta para a página de login com erro
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return "redirect:dashboard";
    }
}
