import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PokemonListComponent} from './pokemon-list/pokemon-list.component';
import { PokemonFormComponent} from './pokemon-form/pokemon-form.component';

const routes: Routes = [
   { path: '', component: PokemonListComponent },
   { path: 'new', component: PokemonFormComponent },
   { path: ':id/edit', component: PokemonFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PokemonsRoutingModule { }
