package com.projetoaula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetoaula.model.Veiculo;
import com.projetoaula.service.VeiculoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
    
    @Autowired
    private VeiculoService servico;

    @GetMapping("/proibidos")
    public String gerenciar(Model model) {
        
        List<Veiculo> veiculos = servico.listarCarrosProibidosRodizio("9");
        model.addAttribute("veiculos", veiculos);

        return "veiculoListar";
    }
    
    @GetMapping("/isentos")
    public String isentos(Model model) {
        
        List<Veiculo> isentos = servico.listarCarrosIsentosIPVA(2005);
        model.addAttribute("veiculos", isentos);

        return "veiculoListar";
    }
    
    @GetMapping("/listar")
    public String listar(Model model) {
        
        List<Veiculo> lista = servico.listar();
        model.addAttribute("veiculos", lista);

        return "veiculoListar";
    }
    
    
    @GetMapping("/adicionar")
    public String adicionarVeiculo(Model model){
        return "veiculoAdicionar";
    }


    @GetMapping("/gerenciar")
    public String gerenciarVeiculos(Model model){
        return "veiculoGerenciar2";
    }

}