import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-streaming-mqtt_2.10",
  name = "Spark Project External MQTT",
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
    "org.eclipse.paho" % "org.eclipse.paho.client.mqttv3" % "1.0.1",
    "org.scalacheck" % "scalacheck_${scala.binary.version}" % "" % "test",
    "junit" % "junit" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test",
    "org.apache.activemq" % "activemq-core" % "5.7.0" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "streaming-mqtt"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes"
  ),
  modelVersion = "4.0.0"
)
