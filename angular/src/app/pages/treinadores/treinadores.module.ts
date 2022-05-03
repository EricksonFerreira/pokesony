import { NgModule } from '@angular/core';

import { SharedModule } from '../../shared/shared.module';

import { TreinadoresRoutingModule } from './treinadores-routing.module';
import { TreinadorListComponent } from './treinador-list/treinador-list.component';
import { TreinadorFormComponent } from './treinador-form/treinador-form.component';


@NgModule({
  declarations: [TreinadorListComponent, TreinadorFormComponent],
  imports: [
    SharedModule,
    TreinadoresRoutingModule,
  ]
})
export class TreinadoresModule { }
