package com.pokemon.convert.tipooposicao;

import com.pokemon.domain.tipooposicao.TipoOposicao;
import com.pokemon.dto.tipooposicao.TipoOposicaoDTO;	

import java.util.List;
import java.util.stream.Collectors;

public class TipoOposicaoConvert {
    private TipoOposicaoConvert() {
	}

	public static List<TipoOposicaoDTO> tipooposicaoDomainListToDTOlist(List<TipoOposicao> domainList) {
			return domainList.stream().map(TipoOposicaoConvert::tipooposicaoDomainToDTO).collect(Collectors.toList());
	}

	public static TipoOposicaoDTO tipooposicaoDomainToDTO(TipoOposicao domain) {
		return TipoOposicaoDTO.builder()
								 .tipoFraco(domain.getTipoOposicaoPK().getTipoFraco())
								 .tipoForte(domain.getTipoOposicaoPK().getTipoForte())
								 .build();
	}
}
