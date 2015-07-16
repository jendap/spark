import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-streaming-kafka-assembly_2.10",
  name = "Spark Project External Kafka Assembly",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.xml"
  ),
  dependencies = Seq(
    "org.apache.spark" % "spark-streaming-kafka_${scala.binary.version}" % "${project.version}",
    "org.apache.spark" % "spark-streaming_${scala.binary.version}" % "${project.version}" % "provided"
  ),
  properties = Map(
    "sbt.project.name" -> "streaming-kafka-assembly"
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
          outputFile = "${project.build.directory}/scala-${scala.binary.version}/spark-streaming-kafka-assembly-${project.version}.jar",
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
  modelVersion = "4.0.0"
)
