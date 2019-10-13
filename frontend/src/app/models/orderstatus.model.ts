export class OrderstatusModel {
  id:string;
  name: string;

  static cloneBase(orderstatus: OrderstatusModel):OrderstatusModel {
    const cloneOrderstatusModel: OrderstatusModel = new OrderstatusModel();
    cloneOrderstatusModel.id = orderstatus.id;
    cloneOrderstatusModel.name = orderstatus.name;
    return cloneOrderstatusModel;
  }
}
