package com.pokemon.repository.treinador;

import com.pokemon.domain.treinador.Treinador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinadorRepository extends JpaRepository<Treinador, Integer> {
}
