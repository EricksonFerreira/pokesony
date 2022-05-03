package com.pokemon.dto.tipooposicao;

import java.io.Serializable;

import com.pokemon.domain.tipo.Tipo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoOposicaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Tipo tipoFraco;
    private Tipo tipoForte;
}