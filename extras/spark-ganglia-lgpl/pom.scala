import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-ganglia-lgpl_2.10",
  name = "Spark Ganglia Integration",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.xml"
  ),
  dependencies = Seq(
    "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
    "io.dropwizard.metrics" % "metrics-ganglia" % ""
  ),
  properties = Map(
    "sbt.project.name" -> "ganglia-lgpl"
  ),
  modelVersion = "4.0.0"
)
