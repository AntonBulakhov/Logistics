import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./modules/pages/home/home.component";
import {OrderformComponent} from "./modules/pages/orderform/orderform.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'orderform', component: OrderformComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
