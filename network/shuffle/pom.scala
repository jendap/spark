import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-network-shuffle",
  name = "Spark Project Shuffle Streaming Service",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" %% "spark-parent" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" %% "spark-network-common" % "${project.version}",
    "org.slf4j" % "slf4j-api" % "" % "provided",
    "com.google.guava" % "guava" % "",
    Dependency(
      "org.apache.spark" %% "spark-network-common" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "junit" % "junit" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test",
    "log4j" % "log4j" % "" % "test",
    "org.mockito" % "mockito-core" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "network-shuffle"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes"
  ),
  modelVersion = "4.0.0"
)
