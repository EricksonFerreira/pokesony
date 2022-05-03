package com.pokemon.dto.tipopokemon;

import java.io.Serializable;

import com.pokemon.domain.pokemon.Pokemon;
import com.pokemon.domain.tipo.Tipo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoPokemonDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer codigo;
    private Tipo tipo;
    private Pokemon pokemon;
}