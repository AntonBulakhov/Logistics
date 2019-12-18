import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./modules/pages/home/home.component";
import {OrderformComponent} from "./modules/pages/orderform/orderform.component";
import {ProfileComponent} from "./modules/pages/profile/profile.component";
import {ConfirmComponent} from "./modules/pages/confirm/confirm.component";
import {CreaterouteComponent} from "./modules/pages/createroute/createroute.component";
import {TablesComponent} from "./modules/pages/tables/tables.component";
import {RegistrationComponent} from "./modules/pages/registration/registration.component";
import {EmployeesComponent} from "./modules/pages/employees/employees.component";
import {ErorComponent} from "./modules/pages/eror/eror.component";
import {CarriersComponent} from "./modules/pages/carriers/carriers.component";
import {DeliveryComponent} from "./modules/pages/delivery/delivery.component";
import {TariffComponent} from "./modules/pages/tariff/tariff.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'orderform', component: OrderformComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'confirm', component: ConfirmComponent},
  {path: 'createroute', component: CreaterouteComponent},
  {path: 'tables', component: TablesComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'employees', component: EmployeesComponent},
  {path: 'carriers', component: CarriersComponent},
  {path: 'error', component: ErorComponent},
  {path: 'delivery', component: DeliveryComponent},
  {path: 'tariff', component: TariffComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
