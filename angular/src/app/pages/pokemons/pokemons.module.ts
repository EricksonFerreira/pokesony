import { NgModule } from '@angular/core';

import { SharedModule } from '../../shared/shared.module';

import { PokemonsRoutingModule } from './pokemons-routing.module';
import { PokemonListComponent } from './pokemon-list/pokemon-list.component';
import { PokemonFormComponent } from './pokemon-form/pokemon-form.component';


@NgModule({
  declarations: [PokemonListComponent, PokemonFormComponent],
  imports: [
    SharedModule,
    PokemonsRoutingModule,
  ]
})
export class PokemonsModule { }
