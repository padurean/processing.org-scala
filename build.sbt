import com.github.retronym.SbtOneJar._

name := """processing.org-scala"""

version := "1.0"

scalaVersion := "2.11.4"

oneJarSettings

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)
