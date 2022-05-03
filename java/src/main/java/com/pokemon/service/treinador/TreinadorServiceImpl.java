package com.pokemon.service.treinador;

import com.pokemon.convert.treinador.TreinadorConvert;
import com.pokemon.domain.treinador.Treinador;
import com.pokemon.dto.treinador.TreinadorDTO;
import com.pokemon.dto.treinador.TreinadorFormDTO;
import com.pokemon.repository.treinador.TreinadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TreinadorServiceImpl implements TreinadorService {

    private final TreinadorRepository treinadorRepository;

    @Override
    public List<TreinadorDTO> listarTreinadors() {
        List<Treinador> treinadors = treinadorRepository.findAll();
        return TreinadorConvert.treinadorDomainListToDTOlist(treinadors);
    }

    @Override
    public TreinadorDTO buscarTreinadorPorCodigo(Integer codigo) throws Exception{
        Optional<Treinador> treinadorOpt = treinadorRepository.findById(codigo);
        if(!treinadorOpt.isPresent()){
        }
        return TreinadorConvert.treinadorDomainToDTO(treinadorOpt.get());
    }

    @Override
    public TreinadorDTO adicionaTreinador(TreinadorFormDTO treinadorFormDTO){
        Treinador entity = TreinadorConvert.treinadorFormToTreinadorEntity(treinadorFormDTO);
        treinadorRepository.save(entity);
        return TreinadorConvert.treinadorDomainToDTO(entity);
    }

    @Override
    public TreinadorDTO editaTreinador(Integer codigo, TreinadorFormDTO treinadorForm) throws Exception {
        Optional<Treinador> treinadorOpt = treinadorRepository.findById(codigo);
        if(!treinadorOpt.isPresent()){
            throw new Exception("Treinador não encotrada");
        }

        Treinador entity = treinadorOpt.get();
        entity.setNome(treinadorForm.getNome());
		treinadorRepository.save(entity);
        return TreinadorConvert.treinadorDomainToDTO(entity);
    }

     @Override
    public void deletaTreinador(Integer codigo) throws Exception {

        Optional<Treinador> treinadorOpt = treinadorRepository.findById(codigo);
        if(!treinadorOpt.isPresent()){
            throw new Exception("Treinador não encontrada");
        }

        treinadorRepository.delete(treinadorOpt.get());
    }
}
