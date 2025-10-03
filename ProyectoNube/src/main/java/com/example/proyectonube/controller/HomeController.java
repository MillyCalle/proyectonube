package com.example.proyectonube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("mensaje", "¡Bienvenido a Proyecto Nube con Spring Boot!");
        return "welcome"; // renderiza welcome.html
    }
}
