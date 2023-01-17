package com.example.thymleaf.controller;

import com.example.thymleaf.dto.auth.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String login(Model model) {
        LoginDTO loginDTO = new LoginDTO();
        model.addAttribute("dto", loginDTO);
        return "login";
    }
}