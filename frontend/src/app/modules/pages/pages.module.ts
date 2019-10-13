import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import {SharedModule} from "../shared/shared.module";
import {BrowserModule} from "@angular/platform-browser";
import {RouterModule} from "@angular/router";
import { OrderformComponent } from './orderform/orderform.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ProfileComponent } from './profile/profile.component';
import { ConfirmComponent } from './confirm/confirm.component';
import { CreaterouteComponent } from './createroute/createroute.component';
import { TablesComponent } from './tables/tables.component';
import { RegistrationComponent } from './registration/registration.component';
import {PointService} from "../../services/point.service";
import {RoleService} from "../../services/role.service";



@NgModule({
  declarations: [
    HomeComponent,
    OrderformComponent,
    ProfileComponent,
    ConfirmComponent,
    CreaterouteComponent,
    TablesComponent,
    RegistrationComponent],
  imports: [
    CommonModule,
    SharedModule,
    BrowserModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    HomeComponent,
    OrderformComponent,
    ProfileComponent,
    ConfirmComponent,
    CreaterouteComponent,
    TablesComponent,
    RegistrationComponent
  ],
  providers: [
    PointService,
    RoleService
  ]
})
export class PagesModule { }
