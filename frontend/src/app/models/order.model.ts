import {RouteModel} from "./route.model";
import {UserModel} from "./user.model";
import {OrderstatusModel} from "./orderstatus.model";

export class OrderModel {
  id: string;
  weight: string;
  value: string;
  cost: string;
  deliveryDate: string;
  user: UserModel;
  orderStatus: OrderstatusModel;
  route: RouteModel;

  static cloneBase(order: OrderModel): OrderModel {
    const cloneOrdertModel: OrderModel = new OrderModel();
    cloneOrdertModel.id = order.id;
    return cloneOrdertModel;
  }
}
