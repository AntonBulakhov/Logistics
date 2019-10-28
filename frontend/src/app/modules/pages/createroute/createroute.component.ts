import {Component, OnInit} from '@angular/core';
import {PointModel} from "../../../models/point.model";
import {PointService} from "../../../services/point.service";
import {SegmentModel} from "../../../models/segment.model";
import {TransportService} from "../../../services/transport.service";
import {TransportModel} from "../../../models/transport.model";
import {SegmentService} from "../../../services/segment.service";
import {RouteModel} from "../../../models/route.model";
import {newRouteModel} from "../../../models/dto/newRoute.model";
import {RouteService} from "../../../services/route.service";

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
  public segments: SegmentModel[];
  public segmentExists: boolean = false;

  public loaded: boolean = false;

  public transports: TransportModel[];

  public inputCount = Array(0).fill(1).map((x, i) => i);
  public route: RouteModel = new RouteModel();
  public segmentsToRoute: SegmentModel[];

  constructor(private pointService: PointService,
              private segmentService: SegmentService,
              private  transportService: TransportService,
              private routeService: RouteService
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
    this.segmentService.getAllSegments().subscribe(data => {
      this.segments = data as SegmentModel[];
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
    if (Object.keys(this.segment).length !== 0 && this.segment.startPoint.name != null && this.segment.endPoint.name != null &&
      this.segment.distance != null && this.segment.transport != null) {
      this.segmentService.createSegment(this.segment).subscribe(value => {
        this.segmentExists = false;
        this.loadData();
      });
    } else {
      this.segmentExists = true;
    }
  }

  createSegmentsInputs(event: any) {
    this.inputCount = Array(+event.target.value).fill(1).map((x, i) => i);
    this.segmentsToRoute = Array(event.target.value);
  }

  createRoute() {
    let routeNew: newRouteModel = new newRouteModel();
    this.route.startPoint = this.segmentsToRoute[0].startPoint;
    this.route.endPoint = this.segmentsToRoute[this.segmentsToRoute.length - 1].endPoint;
    if (this.route.startPoint != null && this.route.endPoint != null) {
      routeNew.route = this.route;
      routeNew.relations = this.segmentsToRoute;
      this.routeService.createRoute(routeNew).subscribe(value => {
        console.log(value);
      })
    }
  }
}
