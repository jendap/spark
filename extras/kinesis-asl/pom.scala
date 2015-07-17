import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-streaming-kinesis-asl",
  name = "Spark Kinesis Integration",
  parent = Parent(
    gav = "org.apache.spark" %% "spark-parent" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" %% "spark-streaming" % "${project.version}",
    Dependency(
      "org.apache.spark" %% "spark-core" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    Dependency(
      "org.apache.spark" %% "spark-streaming" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "com.amazonaws" % "amazon-kinesis-client" % "${aws.kinesis.client.version}",
    "com.amazonaws" % "aws-java-sdk" % "${aws.java.sdk.version}",
    "org.mockito" % "mockito-core" % "" % "test",
    "org.scalacheck" %% "scalacheck" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "kinesis-asl"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes"
  ),
  modelVersion = "4.0.0"
)
