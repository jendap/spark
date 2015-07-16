import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-streaming-flume-sink_2.10",
  name = "Spark Project External Flume Sink",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../../pom.xml"
  ),
  dependencies = Seq(
    Dependency(
      "org.apache.flume" % "flume-ng-sdk",
      exclusions = Seq(
        "com.google.guava" % "guava",
        "org.apache.thrift" % "libthrift"
      )
    ),
    Dependency(
      "org.apache.flume" % "flume-ng-core",
      exclusions = Seq(
        "com.google.guava" % "guava",
        "org.apache.thrift" % "libthrift"
      )
    ),
    "org.scala-lang" % "scala-library" % "",
    "com.google.guava" % "guava" % "" % "test",
    "io.netty" % "netty" % "3.4.0.Final" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "streaming-flume-sink"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    plugins = Seq(
      Plugin(
        "org.apache.avro" % "avro-maven-plugin" % "${avro.version}",
        executions = Seq(
          Execution(
            phase = "generate-sources",
            goals = Seq(
              "idl-protocol"
            )
          )
        ),
        configuration = Config(
          outputDirectory = "${project.basedir}/target/scala-${scala.binary.version}/src_managed/main/compiled_avro"
        )
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-shade-plugin",
        configuration = Config(
          relocations = Config(
            `@combine.self` = "override"
          )
        )
      )
    )
  ),
  modelVersion = "4.0.0"
)
