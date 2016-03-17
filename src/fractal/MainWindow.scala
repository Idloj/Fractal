package fractal

import java.awt._
import java.awt.event._
import javax.swing._

import Math._

object MainWindow extends App {
  EventQueue.invokeLater {
    val window = new MainWindow()
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    window.setSize(400, 400 + window.drawSpace.getHeight)
    window.setVisible(true)
  }
}

class MainWindow extends JFrame("Fractal") {
  addComponentListener(new ComponentAdapter {
    override def componentResized(e: ComponentEvent) = {
      val minDim = min(getWidth, getHeight)
      setSize(minDim, minDim)
    }
  })

  private val drawSpace = new FractalCanvas

  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName)
  setLayout(new BorderLayout)
  add(new JPanel(new FlowLayout) {
    def updateLevelLabel() = levelLabel.setText(drawSpace.level)
    val levelLabel = new JLabel {
      def setText(level: Int) = super.setText(s"Level: $level")
    }
    val inc = new Button("Increase Level", {
        drawSpace.level += 1
        updateLevelLabel()
        dec.setEnabled(true)
      })
    val dec: Button = new Button("Decrease Level", {
        drawSpace.level -= 1
        updateLevelLabel()
        dec.setEnabled(drawSpace.level != 0)
      })

    dec.setEnabled(false)
    updateLevelLabel()
    add(dec)
    add(inc)
    add(levelLabel)
  }, BorderLayout.NORTH)
  add(drawSpace, BorderLayout.CENTER)
}
