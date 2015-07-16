import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-repl_2.10",
  name = "Spark Project REPL",
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
    "org.apache.spark" % "spark-bagel_${scala.binary.version}" % "${project.version}" % "runtime",
    "org.apache.spark" % "spark-mllib_${scala.binary.version}" % "${project.version}" % "runtime",
    "org.apache.spark" % "spark-sql_${scala.binary.version}" % "${project.version}",
    "org.scala-lang" % "scala-compiler" % "${scala.version}",
    "org.scala-lang" % "scala-reflect" % "${scala.version}",
    "org.slf4j" % "jul-to-slf4j" % "",
    "org.scalacheck" % "scalacheck_${scala.binary.version}" % "" % "test",
    "org.mockito" % "mockito-core" % "" % "test",
    "org.eclipse.jetty" % "jetty-server" % "",
    "org.eclipse.jetty" % "jetty-plus" % "",
    "org.eclipse.jetty" % "jetty-util" % "",
    "org.eclipse.jetty" % "jetty-http" % "",
    "org.scala-lang" % "scala-library" % ""
  ),
  properties = Map(
    "extra.source.dir" -> "scala-2.10/src/main/scala",
    "extra.testsource.dir" -> "scala-2.10/src/test/scala",
    "sbt.project.name" -> "repl"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    plugins = Seq(
      Plugin(
        "org.codehaus.mojo" % "build-helper-maven-plugin",
        executions = Seq(
          Execution(
            id = "add-scala-sources",
            phase = "generate-sources",
            goals = Seq(
              "add-source"
            ),
            configuration = Config(
              sources = Config(
                source = "${extra.source.dir}"
              )
            )
          ),
          Execution(
            id = "add-scala-test-sources",
            phase = "generate-test-sources",
            goals = Seq(
              "add-test-source"
            ),
            configuration = Config(
              sources = Config(
                source = "${extra.testsource.dir}"
              )
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
      ),
      dependencies = Seq(
        "${jline.groupid}" % "jline" % "${jline.version}"
      )
    ),
    Profile(
      id = "scala-2.11",
      activation = Activation(
        property = ActivationProperty(
          name = "scala-2.11"
        )
      )
    )
  ),
  modelVersion = "4.0.0"
)
