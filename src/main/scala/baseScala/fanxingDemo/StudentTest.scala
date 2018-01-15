package baseScala.fanxingDemo

/**
  * Created by wanglei on 2017/12/22.
  * 泛型类
  * 案例：新生报道，每个学生来自不同的地方，id可能是int，可能是string
  */
class StudentTest[T](val localId: T) {
  def getSchoolId(hukouId: T) = "S-" + hukouId + "-" + localId
}
