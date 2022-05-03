package com.pokemon.service.pokemon;

import com.pokemon.convert.pokemon.PokemonConvert;
import com.pokemon.domain.pokemon.Pokemon;
import com.pokemon.domain.tipo.Tipo;
import com.pokemon.domain.treinador.Treinador;
import com.pokemon.dto.pokemon.PokemonDTO;
import com.pokemon.dto.pokemon.PokemonFormDTO;
import com.pokemon.repository.pokemon.PokemonRepository;
import com.pokemon.repository.tipo.TipoRepository;
import com.pokemon.repository.treinador.TreinadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PokemonServiceImpl implements PokemonService{

    PokemonRepository pokemonRepository;
    TipoRepository tipoRepository;
    TreinadorRepository treinadorRepository;

    @Override
    public List<PokemonDTO> listarPokemons() {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        return PokemonConvert.pokemonDomainListToDTOlist(pokemons);
    }

    @Override
    public PokemonDTO buscarPokemonPorCodigo(Integer codigo) throws Exception {
          Optional<Pokemon> pokemonOpt = pokemonRepository.findById(codigo);
        if(!pokemonOpt.isPresent()){
            throw new Exception("Não existe esse pokemon!");
        }

        return PokemonConvert.pokemonDomainToDTO(pokemonOpt.get());
    }

    @Override
    public PokemonDTO adicionaPokemon(PokemonFormDTO pokemonFormDTO) throws Exception {

        Optional<Tipo> tipoOpt = tipoRepository.findById(pokemonFormDTO.getTipoId());
        if(!tipoOpt.isPresent()){
            throw new Exception("Não existe esse tipo no sistema");
        }

        Optional<Treinador> treinadorOpt = treinadorRepository.findById(pokemonFormDTO.getTreinadorId());
        if(!treinadorOpt.isPresent()){
            throw new Exception("Não existe esse treinador no sistema");
        }

        Pokemon pokemon =   Pokemon.builder()
                                            .nome(pokemonFormDTO.getNome())
                                            .level(pokemonFormDTO.getLevel())
                                            .tipo(tipoOpt.get())
                                            .treinador(treinadorOpt.get())
                                            .build();
        pokemonRepository.save(pokemon);

        return PokemonConvert.pokemonDomainToDTO(pokemon);
    }

    @Override
    public PokemonDTO editaPokemon(Integer codigo, PokemonFormDTO pokemonFormDTO) throws Exception {
        
        Optional<Tipo> tipoOpt = tipoRepository.findById(pokemonFormDTO.getTipoId());
        if(!tipoOpt.isPresent()){
            throw new Exception("Não existe esse tipo no sistema");
        }

        Optional<Treinador> treinadorOpt = treinadorRepository.findById(pokemonFormDTO.getTreinadorId());
        if(!treinadorOpt.isPresent()){
            throw new Exception("Não existe esse treinador no sistema");
        }

        Optional<Pokemon> pokemonOpt = pokemonRepository.findById(codigo);
        if(!pokemonOpt.isPresent()){
            throw new Exception("Não existe esse pokemon no sistema");
        }

        Pokemon pokemon = pokemonOpt.get();
        pokemon.setNome(pokemonFormDTO.getNome());
        pokemon.setLevel(pokemonFormDTO.getLevel());
        pokemon.setTipo(tipoOpt.get());
        pokemon.setTreinador(treinadorOpt.get());

        return PokemonConvert.pokemonDomainToDTO(pokemon);
    }

    @Override
    public void deletaPokemon(Integer codigo) throws Exception {

        Optional<Pokemon> pokemonOpt = pokemonRepository.findById(codigo);
        if(!pokemonOpt.isPresent()){
            throw new Exception("Não existe pokemon no sistema");
        }
        pokemonRepository.deleteById(codigo);
    }
}
