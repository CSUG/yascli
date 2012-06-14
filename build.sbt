name := "yascli"

organization := "com.github.zhongl"

version := "0.0.2"

scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.9.0","2.9.1","2.9.2")

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies := Seq(
      "jline"           %   "jline"         % "2.7" ,
      "org.mockito"     %   "mockito-all"   % "1.9.0" % "test",
      "org.scalatest"   %%  "scalatest"     % "1.7.2" % "test"
)

publishMavenStyle := true

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))

