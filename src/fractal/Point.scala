package fractal

case class Point(x: Int, y: Int) {
  def +(that: Point) = Point(x+that.x, y+that.y)
  def -(that: Point) = this + -that
  def unary_- = Point(-x, -y)
  def *(d: Double) = Point((d*x).toInt, (d*y).toInt)
  def /(d: Double) = this * (1/d)
}
