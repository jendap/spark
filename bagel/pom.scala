import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-bagel_2.10",
  name = "Spark Project Bagel",
  url = "http://spark.apache.org/",
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
    "org.scalacheck" % "scalacheck_${scala.binary.version}" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "bagel"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes"
  ),
  modelVersion = "4.0.0"
)
