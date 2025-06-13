package com.projetoaula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoaula.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

    
}
