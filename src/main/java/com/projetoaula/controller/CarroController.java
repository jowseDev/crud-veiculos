package com.projetoaula.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/carro")
public class CarroController {
    
@GetMapping("/carroListar")
    public String gerenciar(Model model) {
      
        return "veiculoListar";
    }
    
}
