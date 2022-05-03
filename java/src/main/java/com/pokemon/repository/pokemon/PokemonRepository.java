package com.pokemon.repository.pokemon;

import com.pokemon.domain.pokemon.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
