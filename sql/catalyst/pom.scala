import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-catalyst_2.10",
  name = "Spark Project Catalyst",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.xml"
  ),
  dependencies = Seq(
    "org.scala-lang" % "scala-reflect" % "",
    "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
    Dependency(
      "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "org.apache.spark" % "spark-unsafe_${scala.binary.version}" % "${project.version}",
    "org.scalacheck" % "scalacheck_${scala.binary.version}" % "" % "test",
    "org.codehaus.janino" % "janino" % "2.7.8"
  ),
  properties = Map(
    "sbt.project.name" -> "catalyst"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    plugins = Seq(
      Plugin(
        "org.apache.maven.plugins" % "maven-jar-plugin",
        executions = Seq(
          Execution(
            goals = Seq(
              "test-jar"
            )
          ),
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
  profiles = Seq(
    Profile(
      id = "scala-2.10",
      activation = Activation(
        property = ActivationProperty(
          name = "!scala-2.11"
        )
      )
    )
  ),
  modelVersion = "4.0.0"
)
