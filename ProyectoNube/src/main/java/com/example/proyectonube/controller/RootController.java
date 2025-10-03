package com.example.proyectonube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String home() {
        return "redirect:/login"; // redirige automáticamente a login
    }
}
