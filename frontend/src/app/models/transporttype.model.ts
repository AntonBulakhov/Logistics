export class TransporttypeModel {
  id: string;
  name: string;

  static cloneBase(transporttype: TransporttypeModel): TransporttypeModel {
    const cloneTransporttypeModel: TransporttypeModel = new TransporttypeModel();
    cloneTransporttypeModel.id = transporttype.id;
    cloneTransporttypeModel.name = transporttype.name;
    return cloneTransporttypeModel;
  }
}
