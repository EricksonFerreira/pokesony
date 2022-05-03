import { BaseResourceModel } from '../../../shared/models/base-resource.model';

export class Tipo extends BaseResourceModel {
  constructor(
        public id?: number,
        public nome?: string,
    ) {
      super();
    }
    static fromJson(jsonData: any): Tipo {
      return Object.assign(new Tipo(), jsonData);
    }

}
