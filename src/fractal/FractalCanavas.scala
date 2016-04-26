package fractal

import java.awt._
import javax.swing._

import Math._

class FractalCanvas extends JPanel {
  private var _level = 0
  def level = _level
  def level_=(l: Int) = {
    _level = l
    repaint()
  }

  setBackground(Color.WHITE)

  def drawCurve(level: Int, a: Point, b: Point, g: Graphics): Unit = {
    if (level == 0)
      g.drawLine(a.x, a.y, b.x, b.y)
    else {
      val c = (a * 2 + b) / 3
      val d = (a + b * 2) / 3
      val e = c + (d - c).rotate(PI/3)
      
      drawCurve(level - 1, a, c, g)
      drawCurve(level - 1, c, e, g)
      drawCurve(level - 1, e, d, g)
      drawCurve(level - 1, d, b, g)
    }
  }

  override def paintComponent(g: Graphics) = {
    super.paintComponent(g)
    g.setColor(Color.BLUE)

    val a = Point(getWidth * 1/3, getHeight * 1/3)
    val b = Point(getWidth * 2/3, getHeight * 1/3)
    val c = Point(getWidth * 1/2, getHeight * 2/3)

    drawCurve(level, a, c, g)
    drawCurve(level, c, b, g)
    drawCurve(level, b, a, g)
  }
}

