import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-unsafe_2.10",
  name = "Spark Project Unsafe",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT"
  ),
  dependencies = Seq(
    "com.google.code.findbugs" % "jsr305" % "",
    "com.google.guava" % "guava" % "",
    "org.slf4j" % "slf4j-api" % "" % "provided",
    "junit" % "junit" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test",
    "org.mockito" % "mockito-core" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "unsafe"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    pluginManagement = PluginManagement(
      plugins = Seq(
        Plugin(
          "net.alchim31.maven" % "scala-maven-plugin",
          configuration = Config(
            javacArgs = Config(
              `@combine.children` = "append",
              javacArg = "-XDignore.symbol.file"
            )
          )
        ),
        Plugin(
          "org.apache.maven.plugins" % "maven-compiler-plugin",
          configuration = Config(
            compilerArgs = Config(
              arg = "-XDignore.symbol.file"
            )
          )
        )
      )
    )
  ),
  modelVersion = "4.0.0"
)
