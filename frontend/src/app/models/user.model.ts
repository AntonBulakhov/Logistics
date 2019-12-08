import {RoleModel} from "./role.model";

export class UserModel {
  id:string;
  name: string;
  login: string;
  password: string;
  email: string;
  surname: string;
  blocked: string;
  role: RoleModel;

  static cloneBase(user: UserModel):UserModel {
    const cloneUserModel: UserModel = new UserModel();
    cloneUserModel.id = user.id;
    cloneUserModel.name = user.name;
    return cloneUserModel;
  }
}

export class AuthToken{
  token:string;
}
