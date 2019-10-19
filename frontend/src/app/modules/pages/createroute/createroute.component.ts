import {Component, OnInit} from '@angular/core';
import {PointModel} from "../../../models/point.model";
import {PointService} from "../../../services/point.service";
import {SegmentModel} from "../../../models/segment.model";
import {TransportService} from "../../../services/transport.service";
import {TransportModel} from "../../../models/transport.model";
import {SegmentService} from "../../../services/segment.service";

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

  public transports: TransportModel[];

  constructor(private pointService: PointService,
              private segmentService: SegmentService,
              private  transportService: TransportService
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
    this.pointService.getAllPoints().subscribe(data => {
      this.points = data as PointModel[];
      this.loaded = true;
    });
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
    this.segmentService.createSegment(this.segment).subscribe(value => {
      this.loadData();
    })
  }
}
