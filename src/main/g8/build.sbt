name := "Lift 3 starter template"

version := "0.1.0"

organization := "$organization$"

scalaVersion := "$scala_version$"

resolvers ++= Seq(
  "snapshots"     at "https://oss.sonatype.org/content/repositories/snapshots",
  "staging"       at "https://oss.sonatype.org/content/repositories/staging",
  "releases"      at "https://oss.sonatype.org/content/repositories/releases"
)

enablePlugins(JettyPlugin)

Test / unmanagedResourceDirectories += baseDirectory.value / "src/main/webapp"

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "$lift_version$"
  val liftEdition = liftVersion.split("\\\\.").take(2).mkString(".")
  Seq(
    "net.liftweb"       %% "lift-webkit"            % liftVersion,
    "net.liftweb"       %% "lift-mapper"            % liftVersion,
    "ch.qos.logback"    % "logback-classic"         % "1.2.3",
    "org.specs2"        %% "specs2-core"            % "4.12.12"            % "test",
    "com.h2database"    % "h2"                      % "1.4.187",
    "javax.servlet"     % "javax.servlet-api"       % "3.0.1"            % "provided"
  )
}

Test / scalacOptions ++= Seq("-Yrangepos")
