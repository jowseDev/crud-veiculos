package com.projetoaula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoaula.model.Veiculo;
import java.util.List;


public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    
    List<Veiculo> findByPlacaEndingWith(String numero);
    
    
    List<Veiculo> findByAnofabricacaoLessThanEqual(int anoFabricacao);

}
