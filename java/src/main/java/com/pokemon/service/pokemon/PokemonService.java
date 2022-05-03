package com.pokemon.service.pokemon;


import java.util.List;

import com.pokemon.dto.pokemon.PokemonDTO;
import com.pokemon.dto.pokemon.PokemonFormDTO;

public interface PokemonService {
    public List<PokemonDTO> listarPokemons();
    public PokemonDTO buscarPokemonPorCodigo(Integer codigo) throws Exception;

    public PokemonDTO adicionaPokemon(PokemonFormDTO pokemonFormDTO) throws Exception;
    public PokemonDTO editaPokemon(Integer codigo,PokemonFormDTO pokemonFormDTO) throws Exception;

    public void deletaPokemon(Integer codigo) throws Exception;
}
