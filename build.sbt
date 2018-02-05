val sparkVer = "2.1.2"
val scalaVer = "2.12.4"
val scalaTestVersion = "3.0.0"

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
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.4",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.4"
)

lazy val root = (project in file("."))
  .settings(
    libraryDependencies ++=
        testDependencies ++
        jacksonDependencies
  )

parallelExecution in Test := false

logBuffered in Test := false

scalacOptions ++= Seq(
  "-feature",
  "-language:implicitConversions"
)