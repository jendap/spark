import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-graphx_2.10",
  name = "Spark Project GraphX",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
    Dependency(
      "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "com.google.guava" % "guava" % "",
    "com.github.fommil.netlib" % "core" % "${netlib.java.version}",
    "net.sourceforge.f2j" % "arpack_combined_all" % "0.1",
    "org.scalacheck" % "scalacheck_${scala.binary.version}" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "graphx"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes"
  ),
  modelVersion = "4.0.0"
)
