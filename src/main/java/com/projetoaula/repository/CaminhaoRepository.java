package com.projetoaula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoaula.model.Caminhao;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long>{
    
    List<Caminhao> findByCargaGreaterThanEqual(Double carga);

}
