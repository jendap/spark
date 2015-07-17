import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-streaming-kafka",
  name = "Spark Project External Kafka",
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
    Dependency(
      "org.apache.kafka" %% "kafka" % "0.8.2.1",
      exclusions = Seq(
        "com.sun.jmx" % "jmxri",
        "com.sun.jdmk" % "jmxtools",
        "net.sf.jopt-simple" % "jopt-simple",
        "org.slf4j" % "slf4j-simple",
        "org.apache.zookeeper" % "zookeeper"
      )
    ),
    "net.sf.jopt-simple" % "jopt-simple" % "3.2" % "test",
    "org.scalacheck" %% "scalacheck" % "" % "test",
    "junit" % "junit" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "streaming-kafka"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes"
  ),
  modelVersion = "4.0.0"
)
