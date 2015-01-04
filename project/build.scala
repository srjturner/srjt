import sbt._
import sbt.Keys._

object SrjtBuild extends Build {

  lazy val commonSettings = Seq(
    organization := "com.example",
    version := "0.1.0",
    scalaVersion := "2.10.3"
  )

  val scalatest = "org.scalatest" %% "scalatest" % "1.9.1" % "test"

  lazy val root = project.in(file(".").aggregate(scalalang)

  lazy val scalalang = project.settings(commonSettings: _*).settings(
    libraryDependencies += scalatest
  )

}