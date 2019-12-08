import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NavigationExtras, Router} from "@angular/router";
import {Observable} from "rxjs";
import {AuthToken, UserModel} from "../../models/user.model";
import {UserService} from "../user.service";

@Injectable()
export class AuthService {
  public user: UserModel;
  public token: string;
  public authError: boolean = false;

  constructor(private http: HttpClient,
              private router: Router,
              private userService: UserService) {
    let user = JSON.parse(sessionStorage.getItem('user'));
    let token = sessionStorage.getItem('token');
    if(user && token){
      this.user = user;
      this.token = token;
    }else {
      this.user = null;
      this.token = "";
    }
  }

  public getToken(user: UserModel):Observable<AuthToken>{
    return this.http.post<AuthToken>("/api/auth/token", user);
  }

  public regNewUser(user: UserModel): Observable<UserModel>{
    return this.http.post<UserModel>('api/auth/sign-up',user);
  }

  public userAuth():Observable<UserModel>{
    return this.http.get<UserModel>("/api/auth/user");
  }

  public signIn(authUser: UserModel):void{
    this.getToken(authUser).subscribe(data=>{
      this.token = data.token;
      this.userAuth().subscribe(data=>{
        this.user = data;
        sessionStorage.setItem("user", JSON.stringify(this.user));
        sessionStorage.setItem("token", this.token);
        this.router.navigate(['']);
        setTimeout(location.reload.bind(location), 100);
      })
    }, error1 => {
      this.authError = true;
    })
  }

  public signUp(authUser: UserModel):void{
    this.regNewUser(authUser).subscribe(data=>{
      this.router.navigate(['']);
    })
  }

  // public edit(user: UserModel):void{
  //   sessionStorage.clear();
  //   this.user = null;
  //   this.token = "";
  //   this.regNewUser(user).subscribe(data=>{
  //     this.signIn(user);
  //   });
  // }

  public logOut():void{
    sessionStorage.clear();
    this.user = null;
    this.token = "";
    this.router.navigate(['']);
    setTimeout(location.reload.bind(location), 100);
  }
}
