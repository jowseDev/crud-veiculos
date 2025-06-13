package com.projetoaula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoaula.model.Caminhao;
import com.projetoaula.repository.CaminhaoRepository;

@Service
public class CaminhaoService {
    
    @Autowired
    private CaminhaoRepository repositorio;

    public Caminhao salvar(Caminhao caminhao){

        return repositorio.save(caminhao);
    }

    public List<Caminhao> listar(){
        return repositorio.findAll();
    }

    public void excluir(Long id){
        repositorio.deleteById(id);
    }

    public void alterar(Caminhao caminhao){
        repositorio.save(caminhao);
    }

    public Caminhao carregar(Long id){
        return repositorio.findById(id).orElse(null);
    }

    public List<Caminhao> listarPesados(double peso){
        return repositorio.findByCargaGreaterThanEqual(peso);
    }

}
