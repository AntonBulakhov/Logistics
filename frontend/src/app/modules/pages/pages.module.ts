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
import {RouteService} from "../../services/route.service";
import {TransportService} from "../../services/transport.service";
import { EmployeesComponent } from './employees/employees.component';
import { ErorComponent } from './eror/eror.component';
import { CarriersComponent } from './carriers/carriers.component';
import { DeliveryComponent } from './delivery/delivery.component';
import { TariffComponent } from './tariff/tariff.component';
import { TransportComponent } from './transport/transport.component';



@NgModule({
  declarations: [
    HomeComponent,
    OrderformComponent,
    ProfileComponent,
    ConfirmComponent,
    CreaterouteComponent,
    TablesComponent,
    RegistrationComponent,
    EmployeesComponent,
    ErorComponent,
    CarriersComponent,
    DeliveryComponent,
    TariffComponent,
    TransportComponent],
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
    RegistrationComponent,
    EmployeesComponent
  ],
  providers: [
    PointService,
    RoleService,
    RouteService,
    TransportService
  ]
})
export class PagesModule { }
