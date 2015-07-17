import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-tools",
  name = "Spark Project Tools",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" %% "spark-parent" % "1.5.0-SNAPSHOT",
    relativePath = "../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" %% "spark-core" % "${project.version}",
    "org.apache.spark" %% "spark-streaming" % "${project.version}",
    "org.scala-lang" % "scala-reflect" % "",
    "org.scala-lang" % "scala-compiler" % ""
  ),
  properties = Map(
    "sbt.project.name" -> "tools"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    plugins = Seq(
      Plugin(
        "org.apache.maven.plugins" % "maven-deploy-plugin",
        configuration = Config(
          skip = "true"
        )
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-install-plugin",
        configuration = Config(
          skip = "true"
        )
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-source-plugin"
      )
    )
  ),
  modelVersion = "4.0.0"
)
