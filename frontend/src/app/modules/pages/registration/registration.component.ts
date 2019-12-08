import {Component, OnInit} from '@angular/core';
import {DataService} from "../../../services/data/data.service";
import {RoleService} from "../../../services/role.service";
import {RoleModel} from "../../../models/role.model";
import {UserModel} from "../../../models/user.model";
import {AuthService} from "../../../services/security/auth.service";
import {UserService} from "../../../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  private newUser: UserModel = new UserModel();
  private roles: RoleModel[];
  private confirmPassword: string;

  constructor(private dataService: DataService,
              private roleService: RoleService,
              private auth: AuthService,
              private userService: UserService,
              private router: Router) {
  }

  ngOnInit() {
    this.roleService.getAllRoles().subscribe(value => {
      this.roles = value as RoleModel[];
    });
  }

  public onSubmit() {
    if (this.newUser.password == this.confirmPassword) {
      this.newUser.role = this.getRole();
      if (this.newUser.role.name == 'client') {
        this.auth.signUp(this.newUser);
      } else {
        this.userService.saveUser(this.newUser).subscribe(value => {
          if (value) {
            switch (this.newUser.role.name) {
              case 'employee': {
                this.router.navigate(["/employees"]);
                break;
              }
              case 'admin': {
                this.router.navigate(["/admins"]);
                break;
              }
            }
          }
        })
      }
    }
  }

  public getRole(): RoleModel {
    let roleName: string = this.dataService.getRoleName();
    return this.roles.find(obj => obj.name == roleName);
  }

}
