import {TransportModel} from "../transport.model";

export class NewTransportModel {
  transport: TransportModel = new TransportModel();
  repair: string;
  tires: string;
  fuel: string;
  oil: string;
  tech: string;
}
