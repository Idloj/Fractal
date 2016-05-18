package fractal

import java.awt._
import javax.swing._

abstract class Fractal extends JPanel {
  val name: String

  private var _level = 0
  def level = _level
  def level_=(l: Int) = {
    _level = l
    repaint()
  }

  setBackground(Color.WHITE)
  setForeground(Color.BLUE)
}

