import { Injectable, Injector } from '@angular/core';
import { Tipo } from './tipo.model';

import { BaseResourceService } from '../../../shared/services/base-resource.service';
@Injectable({
  providedIn: 'root'
})
export class TipoService extends BaseResourceService<Tipo> {

  constructor(protected injector: Injector) {
    super('http://localhost:8080/api/tipo', injector, Tipo.fromJson);
  }
}
