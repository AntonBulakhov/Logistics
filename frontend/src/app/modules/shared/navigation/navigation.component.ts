import {Component, OnInit} from '@angular/core';
import {RoleService} from "../../../services/role.service";
import {AuthService} from "../../../services/security/auth.service";
import {UserModel} from "../../../models/user.model";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  public loginUser: UserModel = new UserModel();

  constructor(private roleService: RoleService,
              private auth: AuthService) {
  }

  ngOnInit() {
  }

  public onSubmit(): void {
    this.auth.signIn(this.loginUser);
  }

  public logOut():void{
    this.auth.logOut();
  }
}
