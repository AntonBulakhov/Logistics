import {OrderModel} from "../order.model";
import {PointModel} from "../point.model";

export class NewOrderModel {
  newOrder: OrderModel;
  startPoint: PointModel;
  endPoint: PointModel;
}
