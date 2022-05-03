package com.pokemon.resource.pokemon;

import com.pokemon.dto.pokemon.PokemonDTO;
import com.pokemon.dto.pokemon.PokemonFormDTO;
import com.pokemon.service.pokemon.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/pokemon")
@RequiredArgsConstructor
public class PokemonResource {
     private final PokemonService pokemonService;

    @GetMapping
    public ResponseEntity<List<PokemonDTO>> listaPublicacoes() {
        return ResponseEntity.ok(pokemonService.listarPokemons());
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<PokemonDTO> buscaPokemon(@PathVariable("codigo") Integer codigo) throws Exception {
        return ResponseEntity.ok(pokemonService.buscarPokemonPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<PokemonDTO> adicionaUsuario(@RequestBody PokemonFormDTO pokemonFormDTO) throws Exception {
        PokemonDTO pokemon = pokemonService.adicionaPokemon(pokemonFormDTO);
        return ResponseEntity.ok(pokemon);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<PokemonDTO> editaPokemon(@PathVariable("codigo")Integer codigo,@RequestBody PokemonFormDTO pokemonFormDTO) throws Exception {
        PokemonDTO pokemon = pokemonService.editaPokemon(codigo,pokemonFormDTO);
        return ResponseEntity.status(HttpStatus.OK).body(pokemon);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<PokemonDTO> deletaPokemon(@PathVariable("codigo") Integer codigo) throws Exception {
        pokemonService.deletaPokemon(codigo);
        return ResponseEntity.ok().build();
    }
}
