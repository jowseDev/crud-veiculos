package com.projetoaula.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoaula.model.Veiculo;
import com.projetoaula.service.VeiculoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.persistence.Entity;
import jakarta.xml.ws.Response;
import org.springframework.web.bind.annotation.PutMapping;



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
    // Excluir um veículo pelo ID
    public ResponseEntity<Void> deletePost(@PathVariable long id){
        boolean deleted = VeiculoService.excluirPeloId(id);
            if (deleted) {
                return ResponseEntity.noContent().build(); // 204
             }else{
                return ResponseEntity.notFound().build();// 404
             }

    }
    @PutMapping("/{id}")
    // Atualizar um veículo pelo ID
    public ResponseEntity<Veiculo> updatePost(@PathVariable long id, @RequestBody Veiculo veiculo) {
        Veiculo veiculoAtualizado = VeiculoService.atualizarVeiculo(id, veiculo);
        return ResponseEntity.ok(veiculoAtualizado); // 200 OK
    }

}
