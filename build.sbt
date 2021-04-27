name := "scala-x"

version := "0.1"

scalaVersion := "2.13.5"

lazy val akkaVersion = "2.6.14"

libraryDependencies ++= Seq( //依赖库
  "org.jsoup" % "jsoup" % "1.13.1" % "compile",
  "com.owlike" % "genson-scala_2.10" % "1.4" % "compile",
  "com.google.code.gson" % "gson" % "2.8.6",
  "org.apache.poi" % "poi" % "5.0.0",
  "org.apache.poi" % "poi-ooxml" % "5.0.0",
  "org.scalaj" %% "scalaj-http" % "2.4.2",
  "com.typesafe.play" %% "play-json" % "2.9.2",
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test,
  "org.scalatest" %% "scalatest" % "3.1.0" % Test
)

libraryDependencies += "commons-io" % "commons-io" % "2.8.0"
// https://mvnrepository.com/artifact/org.mongodb.scala/mongo-scala-driver
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.2.3"

