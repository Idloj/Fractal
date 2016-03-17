package fractal

import java.awt.event._
import javax.swing._

class Button(text: String, action: => Unit) extends JButton(text) {
  addActionListener(new ActionListener {
    def actionPerformed(e: ActionEvent) = action
  })
}
