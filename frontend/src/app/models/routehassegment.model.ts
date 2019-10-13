import {RouteModel} from "./route.model";
import {SegmentModel} from "./segment.model";

export class RoutehassegmentModel {
  routeId:RouteModel;
  segmentId: SegmentModel;

  static cloneBase(routehassegment: RoutehassegmentModel):RoutehassegmentModel {
    const cloneRoutehassegmentModel: RoutehassegmentModel = new RoutehassegmentModel();
    return cloneRoutehassegmentModel;
  }
}

