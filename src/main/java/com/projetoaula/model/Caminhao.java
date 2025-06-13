package com.projetoaula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "caminhao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Caminhao extends Veiculo{
    
    private int eixos;

    private double carga;

}
