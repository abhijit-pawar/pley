val sparkVer = "2.2.1"
val scalaVer = "2.11.12"
val scalaTestVersion = "3.0.0"
val jacksonDatabind = "2.9.4"
val jacksonScalaModule = "2.9.4"

name := "pley-analysis"

version := "1.0"

scalaVersion := scalaVer


developers := List(
  Developer(id="abhijit-pawar", name="Abhijit Chandrakant Pawar", email="abhijit.pawar@outlook.com", url=url("https://github.com/abhijit-pawar"))
)

lazy val testDependencies = Seq (
	"org.scalatest" %% "scalatest" % scalaTestVersion % "test"
)

lazy val jacksonDependencies = Seq (
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonDatabind,
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonScalaModule
)

lazy val sparkDependencies = Seq(
  "org.apache.spark" %% "spark-core" % sparkVer % "provided",
  "org.apache.spark" %% "spark-mllib" % sparkVer % "provided"
)

lazy val utilitiesDependencies = Seq (
  "org.slf4j" % "slf4j-api" % "1.7.25"
)

lazy val root = (project in file("."))
  .settings(
    libraryDependencies ++=
      testDependencies ++
        jacksonDependencies ++
        sparkDependencies ++
        utilitiesDependencies
  )

parallelExecution in Test := false

logBuffered in Test := false

scalacOptions ++= Seq(
  "-feature",
  "-language:implicitConversions"
)