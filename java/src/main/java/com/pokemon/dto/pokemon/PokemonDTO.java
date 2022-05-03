package com.pokemon.dto.pokemon;

import java.io.Serializable;

import com.pokemon.dto.tipo.TipoDTO;
import com.pokemon.dto.treinador.TreinadorDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
    private Integer level;
    private TipoDTO tipo;
    private TreinadorDTO treinador;
}