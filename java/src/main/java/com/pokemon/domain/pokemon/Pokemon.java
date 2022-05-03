package com.pokemon.domain.pokemon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.pokemon.domain.tipo.Tipo;
import com.pokemon.domain.treinador.Treinador;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "treinador_id")
    private Treinador treinador;
}

