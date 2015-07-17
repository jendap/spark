import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-mllib",
  name = "Spark Project ML Library",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" %% "spark-parent" % "1.5.0-SNAPSHOT",
    relativePath = "../pom.scala"
  ),
  dependencies = Seq(
    "org.apache.spark" %% "spark-core" % "${project.version}",
    Dependency(
      "org.apache.spark" %% "spark-core" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "org.apache.spark" %% "spark-streaming" % "${project.version}",
    "org.apache.spark" %% "spark-sql" % "${project.version}",
    "org.apache.spark" %% "spark-graphx" % "${project.version}",
    "org.jblas" % "jblas" % "${jblas.version}" % "test",
    Dependency(
      "org.scalanlp" %% "breeze" % "0.11.2",
      exclusions = Seq(
        "junit" % "junit",
        "org.apache.commons" % "commons-math3"
      )
    ),
    "org.apache.commons" % "commons-math3" % "",
    "org.scalacheck" %% "scalacheck" % "" % "test",
    "junit" % "junit" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test",
    "org.mockito" % "mockito-core" % "" % "test",
    Dependency(
      "org.apache.spark" %% "spark-streaming" % "${project.version}",
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
