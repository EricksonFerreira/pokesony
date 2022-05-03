package com.pokemon.resource.tipo;

import com.pokemon.dto.tipo.TipoCheckDTO;
import com.pokemon.dto.tipo.TipoDTO;
import com.pokemon.dto.tipo.TipoFormDTO;
import com.pokemon.dto.tipo.TipoTipoOposicaoDTO;
import com.pokemon.service.tipo.TipoService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/tipo")
@RequiredArgsConstructor
public class TipoResource {

    private final TipoService tipoService;

    @GetMapping
    public ResponseEntity<List<TipoDTO>> listarTipos() {
        return ResponseEntity.ok(tipoService.listarTipos());
    }
    @GetMapping("/check/{codigo}")
    public ResponseEntity<List<TipoCheckDTO>> listarTiposCheck(@PathVariable("codigo") Integer codigo) throws Exception {
        return ResponseEntity.ok(tipoService.listarTiposCheck(codigo));
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<TipoTipoOposicaoDTO> buscarTipo(@PathVariable("codigo") Integer codigo) throws Exception {
        return ResponseEntity.ok(tipoService.buscarTipoPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<TipoTipoOposicaoDTO> adicionaTipo(@RequestBody TipoFormDTO tipoFormDTO) throws Exception{
        TipoTipoOposicaoDTO tipo = tipoService.adicionaTipo(tipoFormDTO);
        return ResponseEntity.ok(tipo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<TipoDTO> editarTipo(@PathVariable("codigo") Integer codigo,@RequestBody TipoFormDTO tipoFormDTO) throws Exception{
        TipoDTO tipo = tipoService.editaTipo(codigo,tipoFormDTO);
        return ResponseEntity.status(HttpStatus.OK).body(tipo);
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<TipoDTO> deletaTipo(@PathVariable("codigo") Integer codigo) throws Exception{
        tipoService.deletaTipo(codigo);
       return ResponseEntity.ok().build();
    }
}
