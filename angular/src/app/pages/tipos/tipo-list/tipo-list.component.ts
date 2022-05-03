import { Component, OnInit } from '@angular/core';

import { BaseResourceListComponent } from '../../../shared/components/base-resource-list/base-resource-list.component';

import { Tipo } from '../shared/tipo.model';
import { TipoService } from '../shared/tipo.service';

@Component({
  selector: 'app-tipo-list',
  templateUrl: './tipo-list.component.html',
  styleUrls: ['./tipo-list.component.css']
})
export class TipoListComponent extends BaseResourceListComponent<Tipo> {


  constructor(private tipoService: TipoService) {
    super(tipoService);
   }

}
