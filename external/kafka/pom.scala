import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-streaming-kafka_2.10",
  name = "Spark Project External Kafka",
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
    Dependency(
      "org.apache.kafka" % "kafka_${scala.binary.version}" % "0.8.2.1",
      exclusions = Seq(
        "com.sun.jmx" % "jmxri",
        "com.sun.jdmk" % "jmxtools",
        "net.sf.jopt-simple" % "jopt-simple",
        "org.slf4j" % "slf4j-simple",
        "org.apache.zookeeper" % "zookeeper"
      )
    ),
    "net.sf.jopt-simple" % "jopt-simple" % "3.2" % "test",
    "org.scalacheck" % "scalacheck_${scala.binary.version}" % "" % "test",
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
