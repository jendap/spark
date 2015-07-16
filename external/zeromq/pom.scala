import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-streaming-zeromq_2.10",
  name = "Spark Project External ZeroMQ",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.xml"
  ),
  dependencies = Seq(
    "org.apache.spark" % "spark-streaming_${scala.binary.version}" % "${project.version}" % "provided",
    Dependency(
      "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "${akka.group}" % "akka-zeromq_${scala.binary.version}" % "",
    "org.scalacheck" % "scalacheck_${scala.binary.version}" % "" % "test",
    "junit" % "junit" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "streaming-zeromq"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes"
  ),
  modelVersion = "4.0.0"
)
