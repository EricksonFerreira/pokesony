import { Component, OnInit } from '@angular/core';

import { BaseResourceListComponent } from '../../../shared/components/base-resource-list/base-resource-list.component';

import { Pokemon } from '../shared/pokemon.model';
import { PokemonService } from '../shared/pokemon.service';

@Component({
  selector: 'app-pokemon-list',
  templateUrl: './pokemon-list.component.html',
  styleUrls: ['./pokemon-list.component.css']
})
export class PokemonListComponent extends BaseResourceListComponent<Pokemon> {


  constructor(private pokemonService: PokemonService) {
    super(pokemonService);
   }

}
