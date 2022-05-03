import { Component, OnInit } from '@angular/core';

import { BaseResourceListComponent } from '../../../shared/components/base-resource-list/base-resource-list.component';

import { Pokemon } from '../shared/pokemon.model';
import { PokemonService } from '../shared/pokemon.service';

@Component({
  selector: 'app-tipo-list',
  templateUrl: './tipo-list.component.html',
  styleUrls: ['./tipo-list.component.css']
})
export class PokemonListComponent extends BaseResourceListComponent<Pokemon> {


  constructor(private tipoService: PokemonService) {
    super(tipoService);
   }

}
