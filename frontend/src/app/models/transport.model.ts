import {TransporttypeModel} from "./transporttype.model";

export class TransportModel {
  id: string;
  name: string;
  speed: string;
  maxValue: string;
  maxWeight: string;
  coefficient: string;
  costPerHour: string;
  transportType: TransporttypeModel;

  static cloneBase(transport: TransportModel): TransportModel {
    const cloneTransportModel: TransportModel = new TransportModel();
    cloneTransportModel.id = transport.id;
    cloneTransportModel.name = transport.name;
    return cloneTransportModel;
  }
}
