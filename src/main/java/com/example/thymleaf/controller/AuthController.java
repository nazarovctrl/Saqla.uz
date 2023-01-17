package com.example.thymleaf.controller;


import com.example.thymleaf.dto.ProfileResponseDTO;
import com.example.thymleaf.dto.auth.LoginDTO;
import com.example.thymleaf.dto.auth.LoginResponseDTO;
import com.example.thymleaf.dto.auth.RegistrationDTO;
import com.example.thymleaf.service.AuthService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }


    @GetMapping("/login")
    private String loginPage(Model model) {
        LoginDTO loginDTO = new LoginDTO();
        model.addAttribute("dto", loginDTO);
        return "login";
    }

    @PostMapping("/registration")
    private ResponseEntity<ProfileResponseDTO> registration(@Valid @RequestBody RegistrationDTO dto) {
        log.info("Registration : email {}, name {}", dto.getEmail(), dto.getName());

        ProfileResponseDTO result = service.registration(dto);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/verification/email/{jwt}")
    private ResponseEntity<String> verification(@PathVariable("jwt") String jwt) {
        log.info("Verification: jwt {}", jwt);
        String result = service.verification(jwt);
        return ResponseEntity.ok(result);
    }


    @PostMapping("/authorization")
    public String login(@ModelAttribute("dto") LoginDTO dto) {
        log.info(" Login :  email {} ", dto.getEmail());
        LoginResponseDTO response = service.login(dto);
        return "cabinet";
    }

}
