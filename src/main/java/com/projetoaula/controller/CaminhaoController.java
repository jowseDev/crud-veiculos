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

import com.projetoaula.model.Caminhao;  
import com.projetoaula.service.CaminhaoService;

@Controller
@RequestMapping("/caminhao")
public class CaminhaoController {
    
    @Autowired
    private CaminhaoService servico;

    @GetMapping("/adicionar")
    public String adicionar(Model model){
        return "caminhaoAdicionar";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Caminhao caminhao){
        servico.salvar(caminhao);
        return "redirect:/caminhao/adicionar";

    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Caminhao> isentos = servico.listar();
        model.addAttribute("caminhoes", isentos);
        return "caminhaoListar";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model){
        Caminhao caminhao = servico.carregar(id);
        model.addAttribute("caminhao", caminhao);
        return "caminhaoAlterar";
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/caminhao/listar");
        servico.excluir(id);
        return modelAndView;
    }

    
    @GetMapping("/pesados")
    public String listarPesados(Model model){
        List<Caminhao> isentos = servico.listarPesados(2000);
        model.addAttribute("caminhoes", isentos);
        return "caminhaoListar";
    }

}
