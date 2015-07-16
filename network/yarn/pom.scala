import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-network-yarn_2.10",
  name = "Spark Project YARN Shuffle Service",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" % "spark-network-shuffle_${scala.binary.version}" % "${project.version}",
    "org.apache.hadoop" % "hadoop-client" % ""
  ),
  properties = Map(
    "hadoop.deps.scope" -> "provided",
    "sbt.project.name" -> "network-yarn"
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
            )
          )
        ),
        configuration = Config(
          shadedArtifactAttached = "false",
          outputFile = "${project.build.directory}/scala-${scala.binary.version}/spark-${project.version}-yarn-shuffle.jar",
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
