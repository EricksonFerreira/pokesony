package com.pokemon.repository.tipopokemon;

import com.pokemon.domain.tipopokemon.TipoPokemon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPokemonRepository extends JpaRepository<TipoPokemon, Integer> {
}
