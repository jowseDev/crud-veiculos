package com.projetoaula.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoaula.model.Veiculo;
import com.projetoaula.service.VeiculoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/veiculoREST")
public class VeiculoRest {

    @Autowired
    private VeiculoService veiculoService;


    @GetMapping("/listar")
    public List<Veiculo> ListarTodosVeiculos(){

        List<Veiculo> veiculos = veiculoService.listar();
        return veiculos;
    }

@PostMapping
public ResponseEntity<Veiculo> createPost(@RequestBody Veiculo veiculo) {
    Veiculo veiculoCadastro = veiculoService.salvar(veiculo);
    return ResponseEntity.status(HttpStatus.CREATED).body(veiculoCadastro);
    }
}
