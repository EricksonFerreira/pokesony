package com.pokemon.dto.treinador;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreinadorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
}