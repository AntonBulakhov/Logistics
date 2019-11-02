import {OrderModel} from "../order.model";
import {PointModel} from "../point.model";

export class NewOrderModel {
  order: OrderModel;
  startPoint: PointModel;
  endPoint: PointModel;
}
