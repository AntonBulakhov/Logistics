import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../services/security/auth.service";
import {UserService} from "../../../services/user.service";
import {UserModel} from "../../../models/user.model";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public user: UserModel = new UserModel();

  constructor(private auth: AuthService,
              private userService: UserService) { }

  ngOnInit() {
    this.userService.getFullUserById(this.auth.user.id).subscribe(value => {
      this.user = value;
    })
  }

}
