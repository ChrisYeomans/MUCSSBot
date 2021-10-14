name := "chris"
version := "0.1"
organization := "com.mucssoc"

javacOptions in (Compile, compile) ++= Seq("-source", "1.8", "-target", "1.8", "-g:lines")

libraryDependencies ++= Seq("org.javacord" % "javacord" % "3.3.2")



crossPaths := false // drop off Scala suffix from artifact names.
autoScalaLibrary := false // exclude scala-library from dependencies