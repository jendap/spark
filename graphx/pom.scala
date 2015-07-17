import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-graphx",
  name = "Spark Project GraphX",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" %% "spark-parent" % "1.5.0-SNAPSHOT",
    relativePath = "../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" %% "spark-core" % "${project.version}",
    Dependency(
      "org.apache.spark" %% "spark-core" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "com.google.guava" % "guava" % "",
    "com.github.fommil.netlib" % "core" % "${netlib.java.version}",
    "net.sourceforge.f2j" % "arpack_combined_all" % "0.1",
    "org.scalacheck" %% "scalacheck" % "" % "test"
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
