import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NavigationComponent} from './navigation/navigation.component';
import {FooterComponent} from './footer/footer.component';
import {RouterModule} from "@angular/router";
import {AuthService} from "../../services/security/auth.service";
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [NavigationComponent, FooterComponent],
  exports: [
    NavigationComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  providers: [
    AuthService
  ]
})
export class SharedModule { }
