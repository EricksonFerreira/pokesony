package com.pokemon.dto.tipopokemon;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoPokemonFormDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer tipoId;
    private Integer pokemonId;
}