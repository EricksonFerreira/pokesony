package com.pokemon.resource.treinador;

import com.pokemon.dto.treinador.TreinadorDTO;
import com.pokemon.dto.treinador.TreinadorFormDTO;
import com.pokemon.service.treinador.TreinadorService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/treinador")
@RequiredArgsConstructor
public class TreinadorResource {

    private final TreinadorService treinadorService;

    @GetMapping
    public ResponseEntity<List<TreinadorDTO>> listarTreinadors() {
        return ResponseEntity.ok(treinadorService.listarTreinadors());
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<TreinadorDTO> buscarTreinador(@PathVariable("codigo") Integer codigo) throws Exception {
        return ResponseEntity.ok(treinadorService.buscarTreinadorPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<TreinadorDTO> adicionaTreinador(@RequestBody TreinadorFormDTO treinadorFormDTO){
        TreinadorDTO treinador = treinadorService.adicionaTreinador(treinadorFormDTO);
        return ResponseEntity.ok(treinador);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<TreinadorDTO> editarTreinador(@PathVariable("codigo") Integer codigo,@RequestBody TreinadorFormDTO treinadorFormDTO) throws Exception{
        TreinadorDTO treinador = treinadorService.editaTreinador(codigo,treinadorFormDTO);
        return ResponseEntity.status(HttpStatus.OK).body(treinador);
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<TreinadorDTO> deletaTreinador(@PathVariable("codigo") Integer codigo) throws Exception{
        treinadorService.deletaTreinador(codigo);
       return ResponseEntity.ok().build();
    }
}
