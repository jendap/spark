import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-streaming",
  name = "Spark Project Streaming",
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
    "org.eclipse.jetty" % "jetty-server" % "",
    "org.eclipse.jetty" % "jetty-plus" % "",
    "org.eclipse.jetty" % "jetty-util" % "",
    "org.eclipse.jetty" % "jetty-http" % "",
    "org.eclipse.jetty" % "jetty-servlet" % "",
    "org.scala-lang" % "scala-library" % "",
    "org.scalacheck" %% "scalacheck" % "" % "test",
    "junit" % "junit" % "" % "test",
    "org.seleniumhq.selenium" % "selenium-java" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "streaming"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    plugins = Seq(
      Plugin(
        "org.apache.maven.plugins" % "maven-shade-plugin",
        configuration = Config(
          shadeTestJar = "true"
        )
      )
    )
  ),
  modelVersion = "4.0.0"
)
