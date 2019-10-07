import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./modules/pages/home/home.component";
import {OrderformComponent} from "./modules/pages/orderform/orderform.component";
import {ProfileComponent} from "./modules/pages/profile/profile.component";
import {ConfirmComponent} from "./modules/pages/confirm/confirm.component";
import {CreaterouteComponent} from "./modules/pages/createroute/createroute.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'orderform', component: OrderformComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'confirm', component: ConfirmComponent},
  {path: 'createroute', component: CreaterouteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
