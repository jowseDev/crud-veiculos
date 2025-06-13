package com.projetoaula.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Onibus extends Veiculo {
    
    private int lugares;

}
