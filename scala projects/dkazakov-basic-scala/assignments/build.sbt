name := "scalafunc"

version := "1.0.0"

scalaVersion := "2.11.4"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.2"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.11.6" % "test"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.2" % "test"

libraryDependencies += "junit" % "junit" % "4.11" % "test"
