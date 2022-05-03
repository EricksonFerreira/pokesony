package com.pokemon.convert.pokemon;

import com.pokemon.convert.tipo.TipoConvert;
import com.pokemon.convert.treinador.TreinadorConvert;
import com.pokemon.domain.pokemon.Pokemon;
import com.pokemon.dto.pokemon.PokemonDTO;	

import java.util.List;
import java.util.stream.Collectors;

public class PokemonConvert {
    private PokemonConvert() {
	}

	public static List<PokemonDTO> pokemonDomainListToDTOlist(List<Pokemon> domainList) {
			return domainList.stream().map(PokemonConvert::pokemonDomainToDTO).collect(Collectors.toList());
	}

	public static PokemonDTO pokemonDomainToDTO(Pokemon domain) {
		return PokemonDTO.builder().id(domain.getId())
								 .nome(domain.getNome())
								 .level(domain.getLevel())
								 .tipo(TipoConvert.tipoDomainToDTO(domain.getTipo()))
								 .treinador(TreinadorConvert.treinadorDomainToDTO(domain.getTreinador()))
								 .build();
	}
}
