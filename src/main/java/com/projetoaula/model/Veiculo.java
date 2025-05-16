package com.projetoaula.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//essa anotação define que a estrategia de persistencia nas classes herdam
//dessa classe será por junção(JOINED)
@Inheritance(strategy = jakarta.persistence.InheritanceType.JOINED)
@Table(name = "veiculo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
    
    @Id
    @GeneratedValue
    @Column(name = "id_veiculo", nullable = false, unique = true )
    private Long id;
    private String placa;
    private int anofabricacao;
}
