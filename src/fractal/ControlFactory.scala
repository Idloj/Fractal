package fractal

import java.awt.event._
import javax.swing._

object ControlFactory {
  def button(text: String)(action: => Unit) = {
    val btn = new JButton(text)
    btn.addActionListener(new ActionListener {
      def actionPerformed(e: ActionEvent) = action
    })
    btn
  }
}
