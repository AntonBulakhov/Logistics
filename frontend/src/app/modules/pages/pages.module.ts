import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import {SharedModule} from "../shared/shared.module";
import {BrowserModule} from "@angular/platform-browser";
import {RouterModule} from "@angular/router";
import { OrderformComponent } from './orderform/orderform.component';
import {FormsModule} from "@angular/forms";
import { ProfileComponent } from './profile/profile.component';
import { ConfirmComponent } from './confirm/confirm.component';



@NgModule({
  declarations: [HomeComponent, OrderformComponent, ProfileComponent, ConfirmComponent],
  imports: [
    CommonModule,
    SharedModule,
    BrowserModule,
    RouterModule,
    FormsModule
  ],
  exports: [
    HomeComponent,
    OrderformComponent,
    ProfileComponent,
    ConfirmComponent
  ]
})
export class PagesModule { }
