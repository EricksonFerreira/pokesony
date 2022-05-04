import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  { path: 'pokemons', loadChildren: () => import('./pages/pokemons/pokemons.module').then(m => m.PokemonsModule) },
  { path: 'treinadores', loadChildren: () => import('./pages/treinadores/treinadores.module').then(m => m.TreinadoresModule) },
  { path: 'tipos', loadChildren: () => import('./pages/tipos/tipos.module').then(m => m.TiposModule) },

  { path: '', redirectTo: 'pokemons', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
