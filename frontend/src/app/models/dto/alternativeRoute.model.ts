import {RouteModel} from "../route.model";
import {SegmentModel} from "../segment.model";

export class AlternativeRouteModel {
  route: RouteModel;
  segments: SegmentModel[];
  price: string;
  deliveryTime: string;

  static cloneBase(alternative: AlternativeRouteModel): AlternativeRouteModel {
    const clone: AlternativeRouteModel = new AlternativeRouteModel();
    clone.route = alternative.route;
    clone.segments = alternative.segments;
    clone.price = alternative.price;
    clone.deliveryTime = alternative.deliveryTime;
    return clone;
  }
}
