package com.projetoaula.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Carro extends Veiculo {
    private int qtd_portas;
    private String cor;
    private Double consumo_medio;


}
