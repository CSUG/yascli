name := "yascli"

organization := "com.github.zhongl"

version := "0.2.0"

scalaVersion := "2.10.0"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-language:reflectiveCalls")

javacOptions += "-Xlint:unchecked"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies := Seq(
      "jline"          % "jline"                % "2.9" ,
      "org.scala-lang" % "scala-library"        % "2.10.0-",
      "org.mockito"    % "mockito-all"          % "1.9.0"   % "test",
      "org.scalatest"  % "scalatest_2.10" % "1.9.1"  % "test"
)

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>http://zhongl.github.com/yascli</url>
  <licenses>
      <license>
        <name>The Apache Software License, Version 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        <distribution>repo</distribution>
        <comments>A business-friendly OSS license</comments>
      </license>
    </licenses>
  <scm>
    <url>git@github.com:zhongl/yascli.git</url>
    <connection>scm:git:git@github.com:zhongl/yascli.git</connection>
  </scm>
  <developers>
    <developer>
      <id>zhongl</id>
      <name>Lunfu Zhong</name>
      <url>http://github.com/zhongl</url>
    </developer>
  </developers>)

// publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))


publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}


