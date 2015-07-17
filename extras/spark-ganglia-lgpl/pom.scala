import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-ganglia-lgpl",
  name = "Spark Ganglia Integration",
  parent = Parent(
    gav = "org.apache.spark" %% "spark-parent" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" %% "spark-core" % "${project.version}",
    "io.dropwizard.metrics" % "metrics-ganglia" % ""
  ),
  properties = Map(
    "sbt.project.name" -> "ganglia-lgpl"
  ),
  modelVersion = "4.0.0"
)
