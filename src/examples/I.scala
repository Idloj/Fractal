package examples

import java.awt.Graphics

import math._

import fractal.Fractal
import util._

class I extends Fractal {
  val name = "I"

  def draw(level: Int, g: Graphics, a: Point, b: Point, factor: Double): Unit = {
    g.drawLine(a.x, a.y, b.x, b.y)
    if (level != 0) {
      val orthogonal = (b - a).rotate(Pi/2) * factor/2

      val aa = a + orthogonal
      val ab = a - orthogonal
      val ba = b + orthogonal
      val bb = b - orthogonal

      draw(level - 1, g, aa, ab, factor)
      draw(level - 1, g, ba, bb, factor)
    }
  }

  override def paintComponent(g: Graphics) = {
    super.paintComponent(g)

    val a = Point(getWidth * 1/4, getHeight * 1/2)
    val b = Point(getWidth * 3/4, getHeight * 1/2)

    draw(level, g, a, b, 0.7)
  }
}
