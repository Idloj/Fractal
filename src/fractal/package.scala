import java.awt.event.{ ActionEvent, ActionListener }

package object fractal {
  implicit def code2runnable(fn: => Unit) = new Runnable { def run() = fn }
  implicit def code2actionListener(fn: ActionEvent => Unit) =
    new ActionListener {
      def actionPerformed(e: ActionEvent) = fn(e)
    }
  implicit def code2actionListener(fn: => Unit): ActionListener = code2actionListener(e => fn)
}
