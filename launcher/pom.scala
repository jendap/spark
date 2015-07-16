import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-launcher_2.10",
  name = "Spark Project Launcher",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT"
  ),
  dependencies = Seq(
    "log4j" % "log4j" % "" % "test",
    "junit" % "junit" % "" % "test",
    "org.mockito" % "mockito-core" % "" % "test",
    "org.slf4j" % "slf4j-api" % "" % "test",
    "org.slf4j" % "slf4j-log4j12" % "" % "test",
    "org.apache.hadoop" % "hadoop-client" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "launcher"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes"
  ),
  modelVersion = "4.0.0"
)
