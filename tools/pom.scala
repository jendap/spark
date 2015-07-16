import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-tools_2.10",
  name = "Spark Project Tools",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
    "org.apache.spark" % "spark-streaming_${scala.binary.version}" % "${project.version}",
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
