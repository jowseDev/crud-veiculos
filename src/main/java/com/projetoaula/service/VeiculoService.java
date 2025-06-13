package com.projetoaula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoaula.model.Veiculo;
import com.projetoaula.repository.VeiculoRepository;

@Service
public class VeiculoService {
 
    @Autowired
    private VeiculoRepository repositorio;

    public List<Veiculo> listarCarrosProibidosRodizio(String numeroFinal){
        return repositorio.findByPlacaEndingWith(numeroFinal);
    }   

    public List<Veiculo> listarCarrosIsentosIPVA(Integer ano){
        return repositorio.findByAnofabricacaoLessThanEqual(ano);
    }

    public Veiculo salvar(Veiculo veiculo) {
    
        return repositorio.save(veiculo);
        
    }

    public List<Veiculo> listar(){
        return repositorio.findAll();
    }

    public boolean excluirPeloId(Long id){

        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }
        return false;
    }

    public Veiculo atualizarVeiculo(long id, Veiculo veiculoAtualizado){

        Veiculo veiculoExistente =  repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com o id " + id));

        veiculoExistente.setAnofabricacao(veiculoAtualizado.getAnofabricacao());
        veiculoExistente.setPlaca(veiculoAtualizado.getPlaca());

        return repositorio.save(veiculoExistente);
    }

}   
