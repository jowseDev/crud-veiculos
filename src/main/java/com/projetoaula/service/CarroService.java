package com.projetoaula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoaula.model.Carro;
import com.projetoaula.repository.CarroRepository;

@Service
public class CarroService {
    
    @Autowired
    private CarroRepository repositorio;

    public List<Carro> listarCarro(){

        return repositorio.findAll();
    }

    public Carro salvar(Carro carro){

        return repositorio.save(carro);
    }

    public void excluir(Long id){
        repositorio.deleteById(id);
    }

    public Carro mudarDados(Long id){
        return repositorio.findById(id).orElse(null);
    }



}
