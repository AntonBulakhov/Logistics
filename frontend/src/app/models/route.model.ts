import {PointModel} from "./point.model";

export class RouteModel {
  id:string;
  startPoint: PointModel;
  endPoint: PointModel;

  static cloneBase(route: RouteModel):RouteModel {
    const cloneRouteModel: RouteModel = new RouteModel();
    cloneRouteModel.id = route.id;
    return cloneRouteModel;
  }
}
