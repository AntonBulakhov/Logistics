import { Component, OnInit } from '@angular/core';
import {TransportModel} from "../../../models/transport.model";
import {TransportService} from "../../../services/transport.service";

@Component({
  selector: 'app-tariff',
  templateUrl: './tariff.component.html',
  styleUrls: ['./tariff.component.css']
})
export class TariffComponent implements OnInit {

  public transports: TransportModel[];

  public loaded: boolean = false;

  constructor( private transportService: TransportService,
  ) {


  }

  ngOnInit() {
    this.loadData();
  }
  private loadData(): void {
    this.transportService.getAllTransport().subscribe(data => {
      this.transports = data as TransportModel[];
      this.loaded = true;
    });
  }
}
