import sbt._
import Keys._

object SrjtBuild extends Build {
  
  lazy val root = project.in(file(".")).aggregate(scalalang)

  lazy val scalalang = project

}