import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TreinadorListComponent} from './treinador-list/treinador-list.component';
import { TreinadorFormComponent} from './treinador-form/treinador-form.component';

const routes: Routes = [
   { path: '', component: TreinadorListComponent },
   { path: 'new', component: TreinadorFormComponent },
   { path: ':id/edit', component: TreinadorFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TreinadoresRoutingModule { }
