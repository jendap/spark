import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-hive_2.10",
  name = "Spark Project Hive",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.xml"
  ),
  dependencies = Seq(
    "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
    Dependency(
      "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "org.apache.spark" % "spark-sql_${scala.binary.version}" % "${project.version}",
    "${hive.group}" % "hive-metastore" % "",
    "commons-httpclient" % "commons-httpclient" % "3.1",
    "${hive.group}" % "hive-exec" % "",
    "org.apache.httpcomponents" % "httpclient" % "${commons.httpclient.version}",
    "org.codehaus.jackson" % "jackson-mapper-asl" % "",
    "${hive.group}" % "hive-serde" % "",
    "org.apache.avro" % "avro" % "",
    Dependency(
      "org.apache.avro" % "avro-mapred",
      classifier = "${avro.mapred.classifier}"
    ),
    "org.scalacheck" % "scalacheck_${scala.binary.version}" % "" % "test",
    "junit" % "junit" % "" % "test",
    Dependency(
      "org.apache.spark" % "spark-sql_${scala.binary.version}" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    Dependency(
      "org.apache.spark" % "spark-catalyst_${scala.binary.version}" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    )
  ),
  properties = Map(
    "sbt.project.name" -> "hive"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    plugins = Seq(
      Plugin(
        "org.scalatest" % "scalatest-maven-plugin",
        configuration = Config(
          argLine = "-da -Xmx3g -XX:MaxPermSize=${MaxPermGen} -XX:ReservedCodeCacheSize=512m"
        )
      ),
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
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-dependency-plugin",
        executions = Seq(
          Execution(
            id = "copy-dependencies",
            phase = "package",
            goals = Seq(
              "copy-dependencies"
            ),
            configuration = Config(
              outputDirectory = "${basedir}/../../lib_managed/jars",
              overWriteReleases = "false",
              overWriteSnapshots = "false",
              overWriteIfNewer = "true",
              includeGroupIds = "org.datanucleus"
            )
          )
        )
      )
    )
  ),
  profiles = Seq(
    Profile(
      id = "hive",
      build = BuildBase(
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
                    source = "compatibility/src/test/scala"
                  )
                )
              )
            )
          )
        )
      )
    )
  ),
  modelVersion = "4.0.0"
)
