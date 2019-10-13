import {PointModel} from "./point.model";
import {TransportModel} from "./transport.model";

export class SegmentModel {
  id: string;
  distance: string;
  cost: string;
  startPoint: PointModel;
  endPoint: PointModel;
  transport: TransportModel;

  static cloneBase(segment: SegmentModel): SegmentModel {
    const cloneSegmentModel: SegmentModel = new SegmentModel();
    cloneSegmentModel.id = segment.id;
    return cloneSegmentModel;
  }
}
