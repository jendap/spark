import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-unsafe",
  name = "Spark Project Unsafe",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" %% "spark-parent" % "1.5.0-SNAPSHOT",
    relativePath = "../pom.scala"
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
