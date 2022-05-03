package com.pokemon.dto.pokemon;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonFormDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nome;
    private Integer level;

    private Integer tipoId;
    private Integer treinadorId;
}