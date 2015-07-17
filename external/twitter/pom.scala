import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-streaming-twitter",
  name = "Spark Project External Twitter",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" %% "spark-parent" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" %% "spark-streaming" % "${project.version}" % "provided",
    Dependency(
      "org.apache.spark" %% "spark-core" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "org.twitter4j" % "twitter4j-stream" % "3.0.3",
    "org.scalacheck" %% "scalacheck" % "" % "test",
    "junit" % "junit" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "streaming-twitter"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes"
  ),
  modelVersion = "4.0.0"
)
