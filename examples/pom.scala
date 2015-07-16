import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-examples_2.10",
  name = "Spark Project Examples",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}" % "provided",
    "org.apache.spark" % "spark-streaming_${scala.binary.version}" % "${project.version}" % "provided",
    "org.apache.spark" % "spark-mllib_${scala.binary.version}" % "${project.version}" % "provided",
    "org.apache.spark" % "spark-bagel_${scala.binary.version}" % "${project.version}" % "provided",
    "org.apache.spark" % "spark-hive_${scala.binary.version}" % "${project.version}" % "provided",
    "org.apache.spark" % "spark-graphx_${scala.binary.version}" % "${project.version}" % "provided",
    "org.apache.spark" % "spark-streaming-twitter_${scala.binary.version}" % "${project.version}",
    "org.apache.spark" % "spark-streaming-flume_${scala.binary.version}" % "${project.version}",
    "org.apache.spark" % "spark-streaming-mqtt_${scala.binary.version}" % "${project.version}",
    Dependency(
      "org.apache.spark" % "spark-streaming-zeromq_${scala.binary.version}" % "${project.version}",
      exclusions = Seq(
        "org.spark-project.protobuf" % "protobuf-java"
      )
    ),
    "org.apache.spark" % "spark-streaming-kafka_${scala.binary.version}" % "${project.version}",
    Dependency(
      "org.apache.hbase" % "hbase-testing-util" % "${hbase.version}",
      scope = "${hbase.deps.scope}",
      exclusions = Seq(
        "org.apache.hbase" % "hbase-annotations",
        "org.jruby" % "jruby-complete"
      )
    ),
    "org.apache.hbase" % "hbase-protocol" % "${hbase.version}" % "${hbase.deps.scope}",
    Dependency(
      "org.apache.hbase" % "hbase-common" % "${hbase.version}",
      scope = "${hbase.deps.scope}",
      exclusions = Seq(
        "org.apache.hbase" % "hbase-annotations"
      )
    ),
    Dependency(
      "org.apache.hbase" % "hbase-client" % "${hbase.version}",
      scope = "${hbase.deps.scope}",
      exclusions = Seq(
        "org.apache.hbase" % "hbase-annotations",
        "io.netty" % "netty"
      )
    ),
    Dependency(
      "org.apache.hbase" % "hbase-server" % "${hbase.version}",
      scope = "${hbase.deps.scope}",
      exclusions = Seq(
        "org.apache.hbase" % "hbase-annotations",
        "org.apache.hadoop" % "hadoop-core",
        "org.apache.hadoop" % "hadoop-client",
        "org.apache.hadoop" % "hadoop-mapreduce-client-jobclient",
        "org.apache.hadoop" % "hadoop-mapreduce-client-core",
        "org.apache.hadoop" % "hadoop-auth",
        "org.apache.hadoop" % "hadoop-annotations",
        "org.apache.hadoop" % "hadoop-hdfs",
        "org.apache.hbase" % "hbase-hadoop1-compat",
        "org.apache.commons" % "commons-math",
        "com.sun.jersey" % "jersey-core",
        "org.slf4j" % "slf4j-api",
        "com.sun.jersey" % "jersey-server",
        "com.sun.jersey" % "jersey-core",
        "com.sun.jersey" % "jersey-json",
        "commons-io" % "commons-io"
      )
    ),
    "org.apache.hbase" % "hbase-hadoop-compat" % "${hbase.version}" % "${hbase.deps.scope}",
    Dependency(
      "org.apache.hbase" % "hbase-hadoop-compat" % "${hbase.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "org.apache.commons" % "commons-math3" % "" % "provided",
    "com.twitter" % "algebird-core_${scala.binary.version}" % "0.9.0",
    "org.scalacheck" % "scalacheck_${scala.binary.version}" % "" % "test",
    Dependency(
      "org.apache.cassandra" % "cassandra-all" % "1.2.6",
      exclusions = Seq(
        "com.google.guava" % "guava",
        "com.googlecode.concurrentlinkedhashmap" % "concurrentlinkedhashmap-lru",
        "com.ning" % "compress-lzf",
        "commons-cli" % "commons-cli",
        "commons-codec" % "commons-codec",
        "commons-lang" % "commons-lang",
        "commons-logging" % "commons-logging",
        "io.netty" % "netty",
        "jline" % "jline",
        "net.jpountz.lz4" % "lz4",
        "org.apache.cassandra.deps" % "avro",
        "org.apache.commons" % "commons-math3",
        "org.apache.thrift" % "libthrift"
      )
    ),
    "com.github.scopt" % "scopt_${scala.binary.version}" % "3.2.0",
    "org.scala-lang" % "scala-library" % "" % "provided"
  ),
  properties = Map(
    "sbt.project.name" -> "examples"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    plugins = Seq(
      Plugin(
        "org.apache.maven.plugins" % "maven-deploy-plugin",
        configuration = Config(
          skip = "true"
        )
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-install-plugin",
        configuration = Config(
          skip = "true"
        )
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-shade-plugin",
        configuration = Config(
          shadedArtifactAttached = "false",
          outputFile = "${project.build.directory}/scala-${scala.binary.version}/spark-examples-${project.version}-hadoop${hadoop.version}.jar",
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
          ),
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
            )
          )
        )
      )
    )
  ),
  profiles = Seq(
    Profile(
      id = "kinesis-asl",
      dependencies = Seq(
        "org.apache.spark" % "spark-streaming-kinesis-asl_${scala.binary.version}" % "${project.version}"
      )
    ),
    Profile(
      id = "flume-provided"
    ),
    Profile(
      id = "hadoop-provided"
    ),
    Profile(
      id = "hbase-provided"
    ),
    Profile(
      id = "hive-provided"
    ),
    Profile(
      id = "parquet-provided"
    )
  ),
  modelVersion = "4.0.0"
)
