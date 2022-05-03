package com.pokemon.domain.tipooposicao;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pokemon.domain.tipo.Tipo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TipoOposicaoPK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "tipoFraco")
    private Tipo tipoFraco;

    @ManyToOne
    @JoinColumn(name = "tipoForte")
    private Tipo tipoForte;
}
