package com.pokemon.domain.tipo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.pokemon.domain.tipooposicao.TipoOposicao;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "tipoOposicaoPK.tipoFraco")
    @Builder.Default
    private List<TipoOposicao> tipoForteContra = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "tipoOposicaoPK.tipoForte")
    private List<TipoOposicao> tipoFracoContra = new ArrayList<>();
}

