import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  // { path: 'categories', loadChildren: './pages/categories/categories.module#CategoriesModule' },
  // A video aula ensina do jeito antigo, eu corrigi!!!
  // { path: 'categories', loadChildren: () => import('./pages/categories/categories.module').then(m => m.CategoriesModule) },
  // { path: 'entries', loadChildren: () => import('./pages/entries/entries.module').then(m => m.EntriesModule) },
  // { path: 'reports', loadChildren: () => import('./pages/reports/reports.module').then(m => m.ReportsModule) },
  { path: 'pokemons', loadChildren: () => import('./pages/pokemons/pokemons.module').then(m => m.PokemonsModule) },
  { path: 'treinadores', loadChildren: () => import('./pages/treinadores/treinadores.module').then(m => m.TreinadoresModule) },
  { path: 'tipos', loadChildren: () => import('./pages/tipos/tipos.module').then(m => m.TiposModule) },

  { path: '', redirectTo: 'treinadores', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
