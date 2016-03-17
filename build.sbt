name := "Fractal"

version := "1.0"

mainClass := Some("fractal.MainWindow")

scalaSource in Compile <<= baseDirectory(_ / "src")

scalacOptions ++= "-deprecation -feature -language:implicitConversions".split(" ").toSeq
