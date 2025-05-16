package com.projetoaula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "caminhao")
@NoArgsConstructor
@AllArgsConstructor
public class Caminhao extends Veiculo {
    
    private int eixos;
    private double carga;

}
