import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./modules/pages/home/home.component";
import {OrderformComponent} from "./modules/pages/orderform/orderform.component";
import {ProfileComponent} from "./modules/pages/profile/profile.component";
import {ConfirmComponent} from "./modules/pages/confirm/confirm.component";
import {CreaterouteComponent} from "./modules/pages/createroute/createroute.component";
import {TablesComponent} from "./modules/pages/tables/tables.component";
import {RegistrationComponent} from "./modules/pages/registration/registration.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'orderform', component: OrderformComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'confirm', component: ConfirmComponent},
  {path: 'createroute', component: CreaterouteComponent},
  {path: 'tables', component: TablesComponent},
  {path: 'registration', component: RegistrationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
