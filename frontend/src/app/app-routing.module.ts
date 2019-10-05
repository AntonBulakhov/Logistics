import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./modules/pages/home/home.component";
import {OrderformComponent} from "./modules/pages/orderform/orderform.component";
import {ProfileComponent} from "./modules/pages/profile/profile.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'orderform', component: OrderformComponent},
  {path: 'profile', component: ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
