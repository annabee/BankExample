lazy val Playground = Project("Playground", file("."))
    .settings(
      version := "1.0",
      scalaVersion := "2.11.8"
    )
    .settings(libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor" % "2.4.4"))