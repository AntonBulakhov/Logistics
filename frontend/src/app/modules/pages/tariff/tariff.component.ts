import {Component, OnInit} from '@angular/core';
import {TransportModel} from "../../../models/transport.model";
import {TransportService} from "../../../services/transport.service";
import {TransporttypeModel} from "../../../models/transporttype.model";
import {AuthService} from "../../../services/security/auth.service";
import {DataService} from "../../../services/data/data.service";

@Component({
  selector: 'app-tariff',
  templateUrl: './tariff.component.html',
  styleUrls: ['./tariff.component.css']
})
export class TariffComponent implements OnInit {

  public transports: TransportModel[] = [];
  public transportTypes: TransporttypeModel[] = [];

  public newTransport: TransportModel = new TransportModel();

  public transportTypeId: string;

  constructor(private transportService: TransportService,
              private auth: AuthService,
              private dataService: DataService) {
  }

  ngOnInit() {
    this.loadData();
  }

  private loadData(): void {
    this.transportTypeId = this.dataService.getTransportTypeId();
    this.transportService.getTransportsByType(this.transportTypeId).subscribe(data => {
      this.transports = data as TransportModel[];
    });
    this.transportService.getAllTypes().subscribe(value => {
      this.transportTypes = value as TransporttypeModel[];
    });
  }

  createTransport(): void {
    this.transportService.createTransport(this.newTransport).subscribe(value => {
      this.ngOnInit();
    });
    this.newTransport = new TransportModel();
  }
}
