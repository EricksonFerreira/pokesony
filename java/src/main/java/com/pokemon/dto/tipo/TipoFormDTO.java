package com.pokemon.dto.tipo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoFormDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nome;
    @Builder.Default
    private List<Integer> tipoForte = new ArrayList<>();
    @Builder.Default
    private List<Integer> tipoFraco = new ArrayList<>();

}