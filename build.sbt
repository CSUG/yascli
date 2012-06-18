name := "yascli"

organization := "com.github.zhongl"

version := "0.1.0"

scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.9.0","2.9.1","2.9.2")

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies := Seq(
      "jline"           %   "jline"         % "2.7" ,
      "org.mockito"     %   "mockito-all"   % "1.9.0" % "test",
      "org.scalatest"   %%  "scalatest"     % "1.7.2" % "test"
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


// publishTo <<= version { (v: String) =>
//  val nexus = "https://oss.sonatype.org/"
//  if (v.trim.endsWith("SNAPSHOT"))
//    Some("snapshots" at nexus + "content/repositories/snapshots")
//  else
//    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
// }


