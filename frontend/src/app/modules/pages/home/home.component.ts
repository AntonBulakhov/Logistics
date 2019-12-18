import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../services/data/data.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private dataService: DataService,
              private router: Router) { }

  ngOnInit() {
  }

  goToTariff(typeId: string): void {
    this.dataService.saveTransportTypeId(typeId);
    this.router.navigate(['/tariff']);
  }

}
