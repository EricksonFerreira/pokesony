import { BaseResourceModel } from '../../../shared/models/base-resource.model';

export class Pokemon extends BaseResourceModel {
  constructor(
        public id?: number,
        public nome?: string,
        public tipo_id?: number,
        public treinador_id?: number
    ) {
      super();
    }
    static fromJson(jsonData: any): Pokemon {
      return Object.assign(new Pokemon(), jsonData);
    }

}
