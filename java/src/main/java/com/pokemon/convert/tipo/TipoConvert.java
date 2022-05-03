package com.pokemon.convert.tipo;

import com.pokemon.domain.tipo.Tipo;
import com.pokemon.domain.tipooposicao.TipoOposicao;
import com.pokemon.dto.tipo.TipoCheckDTO;
import com.pokemon.dto.tipo.TipoDTO;
import com.pokemon.dto.tipo.TipoFormDTO;
import com.pokemon.dto.tipo.TipoTipoOposicaoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TipoConvert {
  	private TipoConvert() {
	}
	
	public static List<TipoDTO> tipoDomainListToDTOlist(List<Tipo> domainList) {
			return domainList.stream().map(TipoConvert::tipoDomainToDTO).collect(Collectors.toList());
	}

	public static TipoDTO tipoDomainToDTO(Tipo domain) {
		return TipoDTO.builder().id(domain.getId()).nome(domain.getNome()).build();
	}
	
	public static TipoCheckDTO tipoDomainToCheckedDTO(Tipo domain, boolean checked) {
		return TipoCheckDTO.builder().id(domain.getId()).nome(domain.getNome()).checked(checked).build();
	}
	
	public static Tipo tipoFormToTipoEntity(TipoFormDTO tipoForm) {
		return Tipo.builder().nome(tipoForm.getNome()).build();
	}

	public static TipoTipoOposicaoDTO tipoDomainWithTipoOposicaoToDTO(Tipo domain) {
		
		List<Integer> tipoForteDto = domain.getTipoForteContra().stream().map(e -> {
			Tipo tipoForte =  e.getTipoOposicaoPK().getTipoForte();
			return tipoForte.getId();
		}).collect(Collectors.toList());

		List<Integer> tipoFracoDto = domain.getTipoFracoContra().stream().map(e -> {
			Tipo tipoFraco =  e.getTipoOposicaoPK().getTipoFraco();
			return tipoFraco.getId();
		}).collect(Collectors.toList());

		return TipoTipoOposicaoDTO.builder().id(domain.getId())
											.nome(domain.getNome())
											.tipoForte(tipoForteDto)
											.tipoFraco(tipoFracoDto)
											.build();
	}

}
