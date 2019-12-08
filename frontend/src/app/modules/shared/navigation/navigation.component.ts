import {Component, OnInit} from '@angular/core';
import {RoleService} from "../../../services/role.service";
import {AuthService} from "../../../services/security/auth.service";
import {UserModel} from "../../../models/user.model";
import {DataService} from "../../../services/data/data.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  public loginUser: UserModel = new UserModel();

  constructor(private roleService: RoleService,
              private auth: AuthService,
              private dataService: DataService,
              private router: Router) {
  }

  ngOnInit() {
  }

  public onSubmit(): void {
    this.auth.signIn(this.loginUser);
  }

  public logOut(): void {
    this.auth.logOut();
  }

  register(role: string) {
    this.dataService.saveRoleName(role);
    this.router.navigate(['/registration']);
  }
}
