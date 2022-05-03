package com.pokemon.domain.tipopokemon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TipoPokemon implements Serializable {

    private static final long serialVersionUID = 1;

    @EmbeddedId
    private TipoPokemonPK id;

}
