import { Component, Injector } from '@angular/core';
import { FormArray, FormBuilder, FormControl, Validators } from '@angular/forms';

import { BaseResourceFormComponent } from '../../../shared/components/base-resource-form/base-resource-form.component';

import { Tipo } from '../shared/tipo.model';
import { TipoService } from '../shared/tipo.service';

@Component({
  selector: 'app-tipo-form',
  templateUrl: './tipo-form.component.html',
  styleUrls: ['./tipo-form.component.css']
})

export class TipoFormComponent extends BaseResourceFormComponent<Tipo> {
  tipos: Tipo[] = [];
  constructor(
    protected tipoService: TipoService,
    protected injector: Injector,
    private fb: FormBuilder
  ) {


    super(injector, new Tipo(), tipoService, Tipo.fromJson);

    this.tipoService.getAll().subscribe(
      resources =>{
        this.tipos = resources.sort((a, b) => b.id - a.id)
        console.log(this.tipos)
    },
      error => alert('Error ao carregar a lista')
    );

      this.resourceForm = this.fb.group({
        tipo_fraco: this.fb.array([]),
        tipo_forte: this.fb.array([])
      })
   }

  // Deixa os campos do formulário vazios
  protected buildResourceForm() {
    this.resourceForm = this.formBuilder.group({
      id: [null],
      nome: [null, [Validators.required, Validators.minLength(2)]],
      tipo_fraco: [[]],
      tipo_forte: [[]]
    });
  }


  onCheckboxChange(e,tipo) {
    const checkArray = this.resourceForm.get(tipo).value == undefined ? [] : this.resourceForm.get(tipo).value;

    const valor = isNaN(e.target.value) ? e.target.value : Number(e.target.value)
console.log(checkArray)
    if (e.target.checked) {
      checkArray.push(valor);
    } else {
      let i: number = 0;
      checkArray.forEach((item) => {
        if (item.id == e.target.value) {
          checkArray.splice(i,1);
          return;
        }
        i++;
      });
    }
  }

  protected creationPageTitle(): string {
    return 'Cadastro de Novo Tipo';
  }

  protected editionPageTitle(): string {
    const resourceNome = this.resource.nome || '';
    return 'Editando Tipo: ' + resourceNome;
  }
}
