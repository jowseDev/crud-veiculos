package com.projetoaula.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetoaula.model.Veiculo;


public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByPlacaEndingWith(String numero);
    List<Veiculo> findByAnofabricacaoLessThanEqual(int anoFabricacao);
    
}
