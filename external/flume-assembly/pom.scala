import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-streaming-flume-assembly_2.10",
  name = "Spark Project External Flume Assembly",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.scala"
  ),
  dependencies = Seq(
    Dependency(
      "org.apache.spark" % "spark-streaming-flume_${scala.binary.version}" % "${project.version}",
      exclusions = Seq(
        "org.mortbay.jetty" % "jetty",
        "org.mortbay.jetty" % "jetty-util"
      )
    ),
    "org.apache.spark" % "spark-streaming_${scala.binary.version}" % "${project.version}" % "provided",
    "commons-codec" % "commons-codec" % "" % "provided",
    "commons-net" % "commons-net" % "" % "provided",
    "com.google.protobuf" % "protobuf-java" % "" % "provided",
    "org.apache.avro" % "avro" % "" % "provided",
    "org.apache.avro" % "avro-ipc" % "" % "provided",
    "org.scala-lang" % "scala-library" % "" % "provided"
  ),
  properties = Map(
    "hadoop.deps.scope" -> "provided",
    "sbt.project.name" -> "streaming-flume-assembly"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    plugins = Seq(
      Plugin(
        "org.apache.maven.plugins" % "maven-shade-plugin",
        executions = Seq(
          Execution(
            phase = "package",
            goals = Seq(
              "shade"
            ),
            configuration = Config(
              transformers = Config(
                transformer = Config(
                  `@implementation` = "org.apache.maven.plugins.shade.resource.ServicesResourceTransformer"
                ),
                transformer = Config(
                  `@implementation` = "org.apache.maven.plugins.shade.resource.AppendingTransformer",
                  resource = "reference.conf"
                ),
                transformer = Config(
                  `@implementation` = "org.apache.maven.plugins.shade.resource.DontIncludeResourceTransformer",
                  resource = "log4j.properties"
                ),
                transformer = Config(
                  `@implementation` = "org.apache.maven.plugins.shade.resource.ApacheLicenseResourceTransformer"
                ),
                transformer = Config(
                  `@implementation` = "org.apache.maven.plugins.shade.resource.ApacheNoticeResourceTransformer"
                )
              )
            )
          )
        ),
        configuration = Config(
          shadedArtifactAttached = "false",
          outputFile = "${project.build.directory}/scala-${scala.binary.version}/spark-streaming-flume-assembly-${project.version}.jar",
          artifactSet = Config(
            includes = Config(
              include = "*:*"
            )
          ),
          filters = Config(
            filter = Config(
              artifact = "*:*",
              excludes = Config(
                exclude = "META-INF/*.SF",
                exclude = "META-INF/*.DSA",
                exclude = "META-INF/*.RSA"
              )
            )
          )
        )
      )
    )
  ),
  profiles = Seq(
    Profile(
      id = "flume-provided"
    )
  ),
  modelVersion = "4.0.0"
)
