
val finagleVersion = "6.45.0"

lazy val myProject = Project("FinagleTest", file("."))
   .settings(
   name := "FinagleTest",
   version := "1.0",
   scalaVersion := "2.12.2",
   libraryDependencies ++= Seq(
      "org.apache.thrift" % "libthrift" % "0.9.2",
      "com.twitter" %% "scrooge-core" % "4.18.0" exclude("com.twitter", "libthrift"),
      "com.twitter" %% "finagle-thrift" % finagleVersion exclude("com.twitter", "libthrift"),
      "com.twitter" %% "finagle-http" % finagleVersion,
      "com.twitter" %% "finagle-core" % finagleVersion
   ),
   scroogeThriftSourceFolder in Compile := {
      val base = baseDirectory.value
      base / "src/main/thrift"
   }
)
