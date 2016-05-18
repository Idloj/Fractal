package fractal

import java.awt._
import java.awt.event._
import javax.swing._

import ControlFactory._

object MainWindow extends App {
  EventQueue.invokeLater {
    val window = new MainWindow(Class.forName(args(0)).newInstance.asInstanceOf[Fractal])
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    window.fractal.setPreferredSize(new Dimension(400, 400))
    window.pack()
    window.setResizable(false)
    window.setVisible(true)
  }
}

class MainWindow(val fractal: Fractal) extends JFrame(fractal.name) {
  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName)
  setLayout(new BorderLayout)
  add(new JPanel(new FlowLayout) {
    def updateLevelLabel() = levelLabel.setText(fractal.level)
    val levelLabel = new JLabel {
      def setText(level: Int) = super.setText(s"Level: $level")
    }
    val inc = button("Increase Level") {
        fractal.level += 1
        updateLevelLabel()
        dec.setEnabled(true)
      }
    val dec: JButton = button("Decrease Level") {
        fractal.level -= 1
        updateLevelLabel()
        dec.setEnabled(fractal.level != 0)
      }

    dec.setEnabled(false)
    updateLevelLabel()
    add(dec)
    add(inc)
    add(levelLabel)
  }, BorderLayout.NORTH)
  add(fractal, BorderLayout.CENTER)
}
