import { Component, OnInit } from '@angular/core';

import { BaseResourceListComponent } from '../../../shared/components/base-resource-list/base-resource-list.component';

import { Treinador } from '../shared/treinador.model';
import { TreinadorService } from '../shared/treinador.service';

@Component({
  selector: 'app-treinador-list',
  templateUrl: './treinador-list.component.html',
  styleUrls: ['./treinador-list.component.css']
})
export class TreinadorListComponent extends BaseResourceListComponent<Treinador> {


  constructor(private treinadorService: TreinadorService) {
    super(treinadorService);
   }

}
