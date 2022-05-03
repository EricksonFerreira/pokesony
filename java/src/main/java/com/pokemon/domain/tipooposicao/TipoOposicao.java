package com.pokemon.domain.tipooposicao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TipoOposicao {
    @EmbeddedId
    TipoOposicaoPK tipoOposicaoPK;
}

