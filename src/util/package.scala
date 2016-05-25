import math._

package object util {
  implicit def double2int(d: Double) = round(d.toFloat)
}
