package com.projetoaula.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Motocicleta extends Veiculo{

    private int cilindradas;

}
