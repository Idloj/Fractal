package examples

import java.awt.Graphics
import javax.swing.JPanel

import fractal.Fractal
import util.Point

class KochSnowflake extends Fractal {
  val name = "Koch Snowflake"

  override def paintComponent(g: Graphics) = {
    super.paintComponent(g)

    val a = Point(getWidth * 1/4, getHeight * 1/4)
    val b = Point(getWidth * 3/4, getHeight * 1/4)
    val c = Point(getWidth * 1/2, getHeight * 3/4)

    val kochCurve = new KochCurve

    kochCurve.draw(level, g, a, b)
    kochCurve.draw(level, g, b, c)
    kochCurve.draw(level, g, c, a)
  }
}
