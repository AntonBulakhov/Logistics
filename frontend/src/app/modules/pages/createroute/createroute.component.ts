import {Component, OnInit} from '@angular/core';
import {PointModel} from "../../../models/point.model";
import {PointService} from "../../../services/point.service";

@Component({
  selector: 'app-createroute',
  templateUrl: './createroute.component.html',
  styleUrls: ['./createroute.component.css']
})
export class CreaterouteComponent implements OnInit {

  public point: PointModel = new PointModel();

  constructor(private pointService: PointService) {
  }

  ngOnInit() {
  }

  createPoint() {
    this.pointService.createPoint(this.point);
  }
}
