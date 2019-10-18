import {Component, OnInit} from '@angular/core';
import {PointModel} from "../../../models/point.model";
import {PointService} from "../../../services/point.service";
import {SegmentModel} from "../../../models/segment.model";

@Component({
  selector: 'app-createroute',
  templateUrl: './createroute.component.html',
  styleUrls: ['./createroute.component.css']
})
export class CreaterouteComponent implements OnInit {

  public point: PointModel = new PointModel();
  public points: PointModel[];
  public pointNameSubmitted: boolean;
  public pointExists: boolean = false;

  public segment: SegmentModel = new SegmentModel();

  public loaded: boolean = false;

  constructor(private pointService: PointService) {
  }

  ngOnInit() {
    this.loadData();
  }

  private loadData(): void {
    this.pointService.getAllPoints().subscribe(data => {
      this.points = data as PointModel[];
      this.loaded = true;
    })
  }

  createPoint() {
    this.pointNameSubmitted = true;
    this.pointService.getPointByName(this.point.name).subscribe(value => {
      if (value == null) {
        this.pointService.createPoint(this.point).subscribe(value => {
          this.pointExists = false;
          this.loadData();
        });
      } else {
        this.pointExists = true;
      }
    });
  }

  createSegment() {

  }
}
