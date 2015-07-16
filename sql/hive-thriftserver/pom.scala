import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-hive-thriftserver_2.10",
  name = "Spark Project Hive Thrift Server",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" % "spark-hive_${scala.binary.version}" % "${project.version}",
    Dependency(
      "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "com.google.guava" % "guava" % "",
    "${hive.group}" % "hive-cli" % "",
    "${hive.group}" % "hive-jdbc" % "",
    "${hive.group}" % "hive-beeline" % "",
    Dependency(
      "org.seleniumhq.selenium" % "selenium-java",
      scope = "test",
      exclusions = Seq(
        "io.netty" % "netty"
      )
    )
  ),
  properties = Map(
    "sbt.project.name" -> "hive-thriftserver"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    plugins = Seq(
      Plugin(
        "org.codehaus.mojo" % "build-helper-maven-plugin",
        executions = Seq(
          Execution(
            id = "add-default-sources",
            phase = "generate-sources",
            goals = Seq(
              "add-source"
            ),
            configuration = Config(
              sources = Config(
                source = "v${hive.version.short}/src/main/scala"
              )
            )
          )
        )
      )
    )
  ),
  modelVersion = "4.0.0"
)
