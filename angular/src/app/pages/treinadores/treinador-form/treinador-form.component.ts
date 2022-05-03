import { Component, Injector } from '@angular/core';
import { Validators } from '@angular/forms';

import { BaseResourceFormComponent } from '../../../shared/components/base-resource-form/base-resource-form.component';

import { Treinador } from '../shared/treinador.model';
import { TreinadorService } from '../shared/treinador.service';

@Component({
  selector: 'app-treinador-form',
  templateUrl: './treinador-form.component.html',
  styleUrls: ['./treinador-form.component.css']
})

export class TreinadorFormComponent extends BaseResourceFormComponent<Treinador> {

  constructor(
    protected treinadorService: TreinadorService,
    protected injector: Injector,
  ) {
    super(injector, new Treinador(), treinadorService, Treinador.fromJson);
   }

  // Deixa os campos do formulário vazios
  protected buildResourceForm() {
    this.resourceForm = this.formBuilder.group({
      id: [null],
      nome: [null, [Validators.required, Validators.minLength(2)]],
      // description: [null]
    });
  }

  protected creationPageTitle(): string {
    return 'Cadastro de Novo Treinador';
  }

  protected editionPageTitle(): string {
    const resourceNome = this.resource.nome || '';
    return 'Editando Treinador: ' + resourceNome;
  }
}
