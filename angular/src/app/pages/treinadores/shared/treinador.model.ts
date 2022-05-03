import { BaseResourceModel } from '../../../shared/models/base-resource.model';

export class Treinador extends BaseResourceModel {
  constructor(
        public id?: number,
        public nome?: string,
    ) {
      super();
    }
    static fromJson(jsonData: any): Treinador {
      return Object.assign(new Treinador(), jsonData);
    }

}
