export class OrderTypeModel {
  id: string;
  name: string;
  coefficient: string;

  static cloneBase(role: OrderTypeModel):OrderTypeModel {
    const cloneRoleModel: OrderTypeModel = new OrderTypeModel();
    cloneRoleModel.id = role.id;
    cloneRoleModel.name = role.name;
    cloneRoleModel.coefficient = role.coefficient;
    return cloneRoleModel;
  }
}
