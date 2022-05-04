import { Component, Injector } from '@angular/core';
import { FormArray, FormBuilder, FormControl, Validators } from '@angular/forms';

import { BaseResourceFormComponent } from '../../../shared/components/base-resource-form/base-resource-form.component';

import { Pokemon } from '../shared/pokemon.model';
import { PokemonService } from '../shared/pokemon.service';
import { TreinadorService } from '../../treinadores/shared/treinador.service';
import { TipoService } from '../../tipos/shared/tipo.service';
import { Treinador } from '../../treinadores/shared/treinador.model';
import { Tipo } from '../../tipos/shared/tipo.model';

@Component({
  selector: 'app-pokemon-form',
  templateUrl: './pokemon-form.component.html',
  styleUrls: ['./pokemon-form.component.css']
})

export class PokemonFormComponent extends BaseResourceFormComponent<Pokemon> {
  treinadores: Treinador[] = [];
  tipos: Tipo[] = [];
  constructor(
    protected pokemonService: PokemonService,
    protected treinadorService: TreinadorService,
    protected tipoService: TipoService,
    protected injector: Injector,
  ) {


    super(injector, new Pokemon(), pokemonService, Pokemon.fromJson);

    this.treinadorService.getAll().subscribe(
      resources =>{
        this.treinadores = resources.sort((a, b) => b.id - a.id)
    },
      error => alert('Error ao carregar a lista de treinadores')
    );

    this.tipoService.getAll().subscribe(
      resources =>{
        this.tipos = resources.sort((a, b) => b.id - a.id)
    },
      error => alert('Error ao carregar a lista de tipos')
    );

      // this.resourceForm = this.fb.group({
      //   pokemon_fraco: this.fb.array([]),
      //   pokemon_forte: this.fb.array([])
      // })
   }

  // Deixa os campos do formulário vazios
  protected buildResourceForm() {
    this.resourceForm = this.formBuilder.group({
      id: [null],
      nome: [null, [Validators.required, Validators.minLength(2)]],
      treinador_id: [null],
      tipo_id: [null]
    });
  }

  protected creationPageTitle(): string {
    return 'Cadastro de Novo Pokemon';
  }

  protected editionPageTitle(): string {
    const resourceNome = this.resource.nome || '';
    return 'Editando Pokemon: ' + resourceNome;
  }
}
