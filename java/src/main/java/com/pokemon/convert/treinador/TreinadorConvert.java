package com.pokemon.convert.treinador;

import com.pokemon.domain.treinador.Treinador;
import com.pokemon.dto.treinador.TreinadorDTO;
import com.pokemon.dto.treinador.TreinadorFormDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TreinadorConvert {
  	private TreinadorConvert() {
	}
	
	public static List<TreinadorDTO> treinadorDomainListToDTOlist(List<Treinador> domainList) {
			return domainList.stream().map(TreinadorConvert::treinadorDomainToDTO).collect(Collectors.toList());
	}

	public static TreinadorDTO treinadorDomainToDTO(Treinador domain) {
		return TreinadorDTO.builder().id(domain.getId()).nome(domain.getNome()).build();
	}
	
	public static Treinador treinadorFormToTreinadorEntity(TreinadorFormDTO treinadorForm) {
		return Treinador.builder().nome(treinadorForm.getNome()).build();
	}

}
