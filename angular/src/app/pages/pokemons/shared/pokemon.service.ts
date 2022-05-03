import { Injectable, Injector } from '@angular/core';
import { Pokemon } from './pokemon.model';

import { BaseResourceService } from '../../../shared/services/base-resource.service';
@Injectable({
  providedIn: 'root'
})
export class PokemonService extends BaseResourceService<Pokemon> {

  constructor(protected injector: Injector) {
    super('http://localhost:8080/api/pokemon', injector, Pokemon.fromJson);
  }
}
