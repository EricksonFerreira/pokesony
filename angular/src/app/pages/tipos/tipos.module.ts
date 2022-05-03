import { NgModule } from '@angular/core';

import { SharedModule } from '../../shared/shared.module';

import { TiposRoutingModule } from './tipos-routing.module';
import { TipoListComponent } from './tipo-list/tipo-list.component';
import { TipoFormComponent } from './tipo-form/tipo-form.component';


@NgModule({
  declarations: [TipoListComponent, TipoFormComponent],
  imports: [
    SharedModule,
    TiposRoutingModule,
  ]
})
export class TiposModule { }
