import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-assembly_2.10",
  packaging = "pom",
  name = "Spark Project Assembly",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
    "org.apache.spark" % "spark-bagel_${scala.binary.version}" % "${project.version}",
    "org.apache.spark" % "spark-mllib_${scala.binary.version}" % "${project.version}",
    "org.apache.spark" % "spark-streaming_${scala.binary.version}" % "${project.version}",
    "org.apache.spark" % "spark-graphx_${scala.binary.version}" % "${project.version}",
    "org.apache.spark" % "spark-sql_${scala.binary.version}" % "${project.version}",
    "org.apache.spark" % "spark-repl_${scala.binary.version}" % "${project.version}"
  ),
  properties = Map(
    "spark.jar.basename" -> "spark-assembly-${project.version}-hadoop${hadoop.version}.jar",
    "spark.jar" -> "${project.build.directory}/${spark.jar.dir}/${spark.jar.basename}",
    "spark.jar.dir" -> "scala-${scala.binary.version}",
    "sbt.project.name" -> "assembly"
  ),
  build = Build(
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
        "org.apache.maven.plugins" % "maven-antrun-plugin",
        executions = Seq(
          Execution(
            phase = "package",
            goals = Seq(
              "run"
            )
          )
        ),
        configuration = Config(
          target = Config(
            delete = Config(
              `@dir` = "${basedir}/../python/lib/pyspark.zip"
            ),
            zip = Config(
              `@destfile` = "${basedir}/../python/lib/pyspark.zip",
              fileset = Config(
                `@includes` = "pyspark/**/*",
                `@dir` = "${basedir}/../python/"
              )
            )
          )
        )
      ),
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
                  resource = "META-INF/services/org.apache.hadoop.fs.FileSystem"
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
          outputFile = "${spark.jar}",
          artifactSet = Config(
            includes = Config(
              include = "*:*"
            )
          ),
          filters = Config(
            filter = Config(
              artifact = "*:*",
              excludes = Config(
                exclude = "org/datanucleus/**",
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
      id = "yarn",
      dependencies = Seq(
        "org.apache.spark" % "spark-yarn_${scala.binary.version}" % "${project.version}"
      )
    ),
    Profile(
      id = "hive",
      dependencies = Seq(
        "org.apache.spark" % "spark-hive_${scala.binary.version}" % "${project.version}"
      )
    ),
    Profile(
      id = "hive-thriftserver",
      dependencies = Seq(
        "org.apache.spark" % "spark-hive-thriftserver_${scala.binary.version}" % "${project.version}"
      )
    ),
    Profile(
      id = "spark-ganglia-lgpl",
      dependencies = Seq(
        "org.apache.spark" % "spark-ganglia-lgpl_${scala.binary.version}" % "${project.version}"
      )
    ),
    Profile(
      id = "bigtop-dist",
      build = BuildBase(
        plugins = Seq(
          Plugin(
            "org.apache.maven.plugins" % "maven-assembly-plugin",
            executions = Seq(
              Execution(
                id = "dist",
                phase = "package",
                goals = Seq(
                  "single"
                ),
                configuration = Config(
                  descriptors = Config(
                    descriptor = "src/main/assembly/assembly.xml"
                  )
                )
              )
            )
          )
        )
      )
    ),
    Profile(
      id = "hadoop-provided"
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
