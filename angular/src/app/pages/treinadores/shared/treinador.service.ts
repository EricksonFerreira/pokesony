import { Injectable, Injector } from '@angular/core';
import { Treinador } from './treinador.model';

import { BaseResourceService } from '../../../shared/services/base-resource.service';
@Injectable({
  providedIn: 'root'
})
export class TreinadorService extends BaseResourceService<Treinador> {

  constructor(protected injector: Injector) {
    super('http://localhost:8080/api/treinador', injector, Treinador.fromJson);
  }
}
