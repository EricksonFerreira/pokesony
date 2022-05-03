package com.pokemon.convert.tipopokemon;

import com.pokemon.domain.tipopokemon.TipoPokemon;
import com.pokemon.dto.tipopokemon.TipoPokemonDTO;	

import java.util.List;
import java.util.stream.Collectors;

public class TipoPokemonConvert {
    private TipoPokemonConvert() {
	}

	public static List<TipoPokemonDTO> tipopokemonDomainListToDTOlist(List<TipoPokemon> domainList) {
			return domainList.stream().map(TipoPokemonConvert::tipopokemonDomainToDTO).collect(Collectors.toList());
	}

	public static TipoPokemonDTO tipopokemonDomainToDTO(TipoPokemon domain) {
		return TipoPokemonDTO.builder()
								 .tipo(domain.getId().getTipo())
								 .pokemon(domain.getId().getPokemon())
								 .build();
	}
}
