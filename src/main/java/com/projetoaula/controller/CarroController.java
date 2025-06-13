package com.projetoaula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projetoaula.model.Carro;
import com.projetoaula.service.CarroService;

@Controller
@RequestMapping("/carro")
public class CarroController {
    
    @Autowired
    private CarroService servico;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Carro> carros = servico.listarCarro();
        model.addAttribute("carros", carros);
        return "carroListar";
    }

    @GetMapping("/adicionar")
    public String adicionar(Model model){
        return "carroAdicionar";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Carro carro){
        servico.salvar(carro);
        return "redirect:/carro/listar";

    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model){
        Carro carro = servico.mudarDados(id);
        model.addAttribute("carro", carro);
        return "carroAlterar";
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/carro/listar");
        servico.excluir(id);
        return modelAndView;
    }

}
