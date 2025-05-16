package com.projetoaula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoaula.model.Veiculo;
import com.projetoaula.repository.VeiculoRepository;

@Service
public class VeiculoService {
@Autowired
private VeiculoRepository veiculoRepository;


    //CARROS PROIBIDOS DE RODAR
    public List<Veiculo> ListaCarrosProibidosRodizio(String numerofinal){
        //CONSULTA A WEBSEREVICE PARA PROCURAR NO BANDO DE DADOS COM BASE NA STRING PASSADA NA FUNÇÃO    
        return veiculoRepository.findByPlacaEndingWith(numerofinal);
    }
    public List<Veiculo> ListaCarrosIsentos(int anoIsento){
        //CONSULTA A WEBSEREVICE PARA PROCURAR NO BANDO DE DADOS COM BASE NA STRING PASSADA NA FUNÇÃO    
        return veiculoRepository.findByAnofabricacaoLessThanEqual(anoIsento);
    }
    //CREATE
    public Veiculo salvar(Veiculo veiculo) {
               return veiculoRepository.save(veiculo);
    }
    //
    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }
   
}
