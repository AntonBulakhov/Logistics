export class PointModel {
  id: string;
  name: string;

  static cloneBase(point: PointModel): PointModel {
    const clonePointModel: PointModel = new PointModel();
    clonePointModel.id = point.id;
    clonePointModel.name = point.name;
    return clonePointModel;
  }
}
