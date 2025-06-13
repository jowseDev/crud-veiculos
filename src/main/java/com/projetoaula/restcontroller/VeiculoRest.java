package com.projetoaula.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoaula.model.Veiculo;
import com.projetoaula.service.VeiculoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/veiculoREST")
public class VeiculoRest {
    
    @Autowired
    private VeiculoService servico;

    @GetMapping
    public List<Veiculo> listarTodosVeiculos(){
        List<Veiculo> veiculos = servico.listar();
        return veiculos;
    }

    @PostMapping
    public ResponseEntity<Veiculo> createPost(@RequestBody Veiculo veiculo){
        Veiculo veiculoCadastrado = servico.salvar(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoCadastrado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        boolean deleted = servico.excluirPeloId(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> updatePost(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        
        Veiculo veiculoAtualizado = servico.atualizarVeiculo(id, veiculo);

        return ResponseEntity.ok(veiculoAtualizado);

    }

}
