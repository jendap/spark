import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "org.apache.spark" % "spark-mllib_2.10",
  name = "Spark Project ML Library",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" % "spark-parent_2.10" % "1.5.0-SNAPSHOT",
    relativePath = "../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
    Dependency(
      "org.apache.spark" % "spark-core_${scala.binary.version}" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "org.apache.spark" % "spark-streaming_${scala.binary.version}" % "${project.version}",
    "org.apache.spark" % "spark-sql_${scala.binary.version}" % "${project.version}",
    "org.apache.spark" % "spark-graphx_${scala.binary.version}" % "${project.version}",
    "org.jblas" % "jblas" % "${jblas.version}" % "test",
    Dependency(
      "org.scalanlp" % "breeze_${scala.binary.version}" % "0.11.2",
      exclusions = Seq(
        "junit" % "junit",
        "org.apache.commons" % "commons-math3"
      )
    ),
    "org.apache.commons" % "commons-math3" % "",
    "org.scalacheck" % "scalacheck_${scala.binary.version}" % "" % "test",
    "junit" % "junit" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test",
    "org.mockito" % "mockito-core" % "" % "test",
    Dependency(
      "org.apache.spark" % "spark-streaming_${scala.binary.version}" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    Dependency(
      "org.jpmml" % "pmml-model" % "1.1.15",
      exclusions = Seq(
        "com.sun.xml.fastinfoset" % "FastInfoset",
        "com.sun.istack" % "istack-commons-runtime"
      )
    )
  ),
  properties = Map(
    "sbt.project.name" -> "mllib"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes"
  ),
  profiles = Seq(
    Profile(
      id = "netlib-lgpl",
      dependencies = Seq(
        Dependency(
          "com.github.fommil.netlib" % "all" % "${netlib.java.version}",
          `type` = "pom"
        )
      )
    )
  ),
  modelVersion = "4.0.0"
)
