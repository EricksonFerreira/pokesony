package com.pokemon.service.tipo;

import com.pokemon.convert.tipo.TipoConvert;
import com.pokemon.domain.tipo.Tipo;
import com.pokemon.domain.tipooposicao.TipoOposicao;
import com.pokemon.domain.tipooposicao.TipoOposicaoPK;
import com.pokemon.dto.tipo.TipoCheckDTO;
import com.pokemon.dto.tipo.TipoDTO;
import com.pokemon.dto.tipo.TipoFormDTO;
import com.pokemon.dto.tipo.TipoTipoOposicaoDTO;
import com.pokemon.repository.tipo.TipoRepository;
import com.pokemon.repository.tipooposicao.TipoOposicaoRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class TipoServiceImpl implements TipoService {

    private final TipoRepository tipoRepository;
    private final TipoOposicaoRepository tipoOposicaoRepository;
    
    @Override
    public List<TipoCheckDTO> listarTiposCheck(Integer codigo){
        Optional<Tipo> tipoOpt = tipoRepository.findById(codigo);
        TipoTipoOposicaoDTO tipotipooposicao= TipoConvert.tipoDomainWithTipoOposicaoToDTO(tipoOpt.get());
        List<TipoCheckDTO> tipoForte;
        List<TipoCheckDTO> tipoFraco;
        List<Tipo> tipos = tipoRepository.findAll();

        List<TipoCheckDTO> tipoForteDto = new ArrayList<>();
        tipos.stream().forEach(tipo -> {
            boolean check;
            // tipotipooposicao.getTipoForte().stream().forEach(tipoFortre ->{
                // if(tipo.getId() == tipoFortre){
                //     check = true;
                // }else{
                //     check = false;
                // };
            // });
            tipoForteDto.add(TipoCheckDTO.builder().id(tipo.getId()).nome(tipo.getNome()).checked(false).build());
		});
        return tipoForteDto;
        // tipoFortes.stream().forEach(tipo -> {
        //     tipotipooposicao.getTipoForte().stream().forEach(tipoForte->{
        //         if(tipo.getId() == tipoForte){
        //             tipo.
        //         }
        //     });
        //     tipotipooposicao.getTipoForte().stream().forEach(tipoFraco->{

        //     });
        // });
        // return null;
    }

    private boolean extracted(boolean check, TipoTipoOposicaoDTO tipo, Integer tipoFortre) {
        if(tipo.getId() == tipoFortre){
            check = true;
        }
        return check;
    };

    @Override
    public List<TipoDTO> listarTipos() {
        List<Tipo> tipos = tipoRepository.findAll();
        return TipoConvert.tipoDomainListToDTOlist(tipos);
    }

    @Override
    public TipoTipoOposicaoDTO buscarTipoPorCodigo(Integer codigo) throws Exception{
        Optional<Tipo> tipoOpt = tipoRepository.findById(codigo);
        if(!tipoOpt.isPresent()){
            throw new Exception("Não existe esse tipo salvo no sistema!");
        }
        return TipoConvert.tipoDomainWithTipoOposicaoToDTO(tipoOpt.get());


        // List<TipoOposicao> tipoOp = tipoOposicaoRepository.findByTipoRepresentacao(tipoOpt.get().getId());

        // return null;
        // return TipoConvert.tipoDomainWithTipoOposicaoToDTO(tipoOpt.get(),tipoOp);
        // return TipoConvert.tipoDomainToDTO(tipoOpt.get());
    }

    @Override
    public TipoTipoOposicaoDTO adicionaTipo(TipoFormDTO tipoFormDTO) throws Exception{
        // Verificação de tipos de oposicao
        // if(sizeTipoOpostoStrong > 0){
        //     Stream<Integer> tiposRepre = tipoFormDTO.getTipoForte().stream().filter(codigo -> {
        //         Optional<Tipo> tipoOpt = tipoRepository.findById(codigo);
        //         if(!tipoOpt.isPresent()){
        //             return false;
        //         }
                
        //         return true;
        //     });
        //     if(tiposRepre.count() != tipoFormDTO.getTipoForte().size()){
        //         throw new Exception("Existem tipos de mais fortes que não estão salvos no sistema!");
        //     }
        // };
        
        // // Verificação de tipos de representacoes
        // Integer sizeTipoOpostoWeak = tipoFormDTO.getTipoFraco().size();
        // if(sizeTipoOpostoWeak > 0){
        //     Stream<Integer> tiposOpo = tipoFormDTO.getTipoFraco().stream().filter(codigo -> {
        //         Optional<Tipo> tipoOpt = tipoRepository.findById(codigo);
        //         if(!tipoOpt.isPresent()){
        //             return false;
        //         }

        //         return true;
        //     });
        //     if(tiposOpo.count() != tipoFormDTO.getTipoFraco().size()){
        //         throw new Exception("Existem tipos fracos que não estão salvos no sistema!");
        //     }
        // };

        Tipo entity = TipoConvert.tipoFormToTipoEntity(tipoFormDTO);
        Tipo tipoSave = tipoRepository.save(entity);
        for (Integer codigo : tipoFormDTO.getTipoForte()) {
            Optional<Tipo> tipoOp = tipoRepository.findById(codigo);
            if (!tipoOp.isPresent()) {
                throw new Exception("O codigo " + codigo + " salvos no sistema!");
            }
            TipoOposicao tipoOposicao = TipoOposicao.builder()
                    .tipoOposicaoPK(TipoOposicaoPK.builder().tipoForte(tipoOp.get()).tipoFraco(tipoSave).build())
                    .build();
            tipoOposicaoRepository.save(tipoOposicao);
            //return tipoOposicaoRepository.save(tipoOposicao);
        }

        for (Integer codigo : tipoFormDTO.getTipoFraco()) {
            Optional<Tipo> tipoOp = tipoRepository.findById(codigo);
            if (!tipoOp.isPresent()) {
                throw new Exception("O codigo " + codigo + " salvos no sistema!");
            }
            TipoOposicao tipoOposicao = TipoOposicao.builder()
                    .tipoOposicaoPK(TipoOposicaoPK.builder().tipoFraco(tipoOp.get()).tipoForte(tipoSave).build())
                    .build();
            tipoOposicaoRepository.save(tipoOposicao);
            //return tipoOposicaoRepository.save(tipoOposicao);
        }

        // tipoFormDTO.getTipoFraco().stream().forEach(codigo -> {
        //         Optional<Tipo> tipoOp = tipoRepository.findById(codigo);
        //         TipoOposicao tipoOposicao = TipoOposicao.builder()
        //         .tipoOposicaoPK(TipoOposicaoPK.builder().tipoForte(tipoOp.get()).tipoFraco(tipoSave).build())
        //         .build();
        //         tipoOposicaoRepository.save(tipoOposicao);
        //     });

        //  tipoOp;
        // List<TipoOposicao> tipoOp = tipoOposicaoRepository.findByTipoRepresentacao(tipoSave.getId());

        // List<TipoOposicao> tiposOposicoes = null;
        // if(tipoOp.isPresent()){
        //     tiposOposicoes = tipoOp.get();
        // }
        Tipo tipoOptional = tipoRepository.findById(tipoSave.getId()).orElse(null);
        tipoOptional.getTipoForteContra();
        tipoOptional.getTipoFracoContra();
        return TipoConvert.tipoDomainWithTipoOposicaoToDTO(tipoOptional);
    }

    @Override
    public TipoDTO editaTipo(Integer codigo, TipoFormDTO tipoForm) throws Exception {
        Optional<Tipo> tipoOpt = tipoRepository.findById(codigo);
        if(!tipoOpt.isPresent()){
            throw new Exception("Tipo não encotrada");
        }

        Tipo entity = tipoOpt.get();
        entity.setNome(tipoForm.getNome());
		tipoRepository.save(entity);
        return TipoConvert.tipoDomainToDTO(entity);
    }

     @Override
    public void deletaTipo(Integer codigo) throws Exception {

        Optional<Tipo> tipoOpt = tipoRepository.findById(codigo);
        if(!tipoOpt.isPresent()){
            throw new Exception("Tipo não encontrada");
        }

        tipoRepository.delete(tipoOpt.get());
    }
}
