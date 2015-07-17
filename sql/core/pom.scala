import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-sql",
  name = "Spark Project SQL",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" %% "spark-parent" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" %% "spark-core" % "${project.version}",
    Dependency(
      "org.apache.spark" %% "spark-core" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "org.apache.spark" %% "spark-catalyst" % "${project.version}",
    Dependency(
      "org.apache.spark" %% "spark-catalyst" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "org.apache.parquet" % "parquet-column" % "",
    "org.apache.parquet" % "parquet-hadoop" % "",
    "com.fasterxml.jackson.core" % "jackson-databind" % "${fasterxml.jackson.version}",
    "junit" % "junit" % "" % "test",
    "org.scalacheck" %% "scalacheck" % "" % "test",
    "com.h2database" % "h2" % "1.4.183" % "test",
    "mysql" % "mysql-connector-java" % "5.1.34" % "test",
    "org.postgresql" % "postgresql" % "9.3-1102-jdbc41" % "test",
    "org.apache.parquet" % "parquet-avro" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "sql"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    plugins = Seq(
      Plugin(
        "org.codehaus.mojo" % "build-helper-maven-plugin",
        executions = Seq(
          Execution(
            id = "add-scala-test-sources",
            phase = "generate-test-sources",
            goals = Seq(
              "add-test-source"
            ),
            configuration = Config(
              sources = Config(
                source = "src/test/gen-java"
              )
            )
          )
        )
      )
    )
  ),
  modelVersion = "4.0.0"
)
