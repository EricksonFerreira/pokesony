import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TipoListComponent} from './tipo-list/tipo-list.component';
import { TipoFormComponent} from './tipo-form/tipo-form.component';

const routes: Routes = [
   { path: '', component: TipoListComponent },
   { path: 'new', component: TipoFormComponent },
   { path: ':id/edit', component: TipoFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TiposRoutingModule { }
