import {Component, OnInit} from '@angular/core';
import {TransporttypeModel} from "../../../models/transporttype.model";
import {NewTransportModel} from "../../../models/dto/newtransport.model";
import {TransportService} from "../../../services/transport.service";
import {AuthService} from "../../../services/security/auth.service";
import {DataService} from "../../../services/data/data.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-transport',
  templateUrl: './transport.component.html',
  styleUrls: ['./transport.component.css']
})
export class TransportComponent implements OnInit {

  public newTransport: NewTransportModel = new NewTransportModel();
  public transportTypes: TransporttypeModel[] = [];

  constructor(private transportService: TransportService,
              private auth: AuthService,
              private router: Router) {
  }

  ngOnInit() {
    this.transportService.getAllTypes().subscribe(value => {
      this.transportTypes = value as TransporttypeModel[];
    });
  }

  onSubmit() {
    this.transportService.createTransport(this.newTransport).subscribe(value => {
      this.router.navigate(['/']);
    });
  }
}
