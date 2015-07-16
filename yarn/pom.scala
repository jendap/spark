import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-yarn_2.10",
  name = "Spark Project YARN",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT"
  ),
  dependencies = Seq(
    "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
    Dependency(
      "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "org.apache.hadoop" % "hadoop-yarn-api" % "",
    "org.apache.hadoop" % "hadoop-yarn-common" % "",
    "org.apache.hadoop" % "hadoop-yarn-server-web-proxy" % "",
    "org.apache.hadoop" % "hadoop-yarn-client" % "",
    "org.apache.hadoop" % "hadoop-client" % "",
    "com.google.guava" % "guava" % "",
    "org.eclipse.jetty" % "jetty-server" % "",
    "org.eclipse.jetty" % "jetty-plus" % "",
    "org.eclipse.jetty" % "jetty-util" % "",
    "org.eclipse.jetty" % "jetty-http" % "",
    "org.eclipse.jetty" % "jetty-servlet" % "",
    Dependency(
      "org.apache.hadoop" % "hadoop-yarn-server-tests",
      classifier = "tests",
      scope = "test"
    ),
    "org.mockito" % "mockito-core" % "" % "test",
    Dependency(
      "org.mortbay.jetty" % "jetty" % "6.1.26",
      scope = "test",
      exclusions = Seq(
        "org.mortbay.jetty" % "servlet-api"
      )
    ),
    "com.sun.jersey" % "jersey-core" % "${jersey.version}" % "test",
    Dependency(
      "com.sun.jersey" % "jersey-json" % "${jersey.version}",
      scope = "test",
      exclusions = Seq(
        "stax" % "stax-api"
      )
    ),
    "com.sun.jersey" % "jersey-server" % "${jersey.version}" % "test"
  ),
  properties = Map(
    "jersey.version" -> "1.9",
    "sbt.project.name" -> "yarn"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes"
  ),
  modelVersion = "4.0.0"
)
