name := "spark-seed"

version := "0.1"

scalaVersion := "2.11.7"

lazy val sparkVersion = "1.6.0"

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "org.json4s" %% "json4s-native" % "3.3.0",
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "com.holdenkarau" % "spark-testing-base_2.11" % "1.6.0_0.3.1",
  "org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)

enablePlugins(JavaAppPackaging)
