package com.pokemon.domain.tipopokemon ;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.pokemon.domain.pokemon.Pokemon;
import com.pokemon.domain.tipo.Tipo;

import java.io.Serializable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoPokemonPK implements Serializable {

    private static final long serialVersionUID = 1;

    @ManyToOne
    private Tipo tipo;

    @ManyToOne
    private Pokemon pokemon;

}
