name := "scalalang"

version := "1.0"

scalaVersion := "2.10.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"

scalacOptions ++= Seq("-feature", "-language:implicitConversions", "-language:reflectiveCalls")