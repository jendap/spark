import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-network-common",
  name = "Spark Project Networking",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" %% "spark-parent" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.scala"
  ),
  dependencies = Seq(
    "io.netty" % "netty-all" % "",
    "org.slf4j" % "slf4j-api" % "" % "provided",
    "com.google.guava" % "guava" % "" % "compile",
    "junit" % "junit" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test",
    "log4j" % "log4j" % "" % "test",
    "org.mockito" % "mockito-core" % "" % "test",
    "org.slf4j" % "slf4j-log4j12" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "network-common"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    plugins = Seq(
      Plugin(
        "org.apache.maven.plugins" % "maven-jar-plugin",
        executions = Seq(
          Execution(
            id = "test-jar-on-test-compile",
            phase = "test-compile",
            goals = Seq(
              "test-jar"
            )
          )
        )
      )
    )
  ),
  modelVersion = "4.0.0"
)
