package com.pokemon.service.treinador;

import com.pokemon.dto.treinador.TreinadorDTO;
import com.pokemon.dto.treinador.TreinadorFormDTO;

import java.util.List;

public interface TreinadorService {
    public List<TreinadorDTO> listarTreinadors();
    public TreinadorDTO buscarTreinadorPorCodigo(Integer codigo) throws Exception;

    public TreinadorDTO adicionaTreinador(TreinadorFormDTO treinadorFormDTO);
    public TreinadorDTO editaTreinador(Integer codigo,TreinadorFormDTO treinadorFormDTO) throws Exception;

    public void deletaTreinador(Integer codigo) throws Exception;
}
