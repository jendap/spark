import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "java8-tests",
  packaging = "pom",
  name = "Spark Project Java8 Tests POM",
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
    "org.apache.spark" %% "spark-streaming" % "${project.version}",
    Dependency(
      "org.apache.spark" %% "spark-streaming" % "${project.version}",
      `type` = "test-jar",
      scope = "test"
    ),
    "junit" % "junit" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test"
  ),
  properties = Map(
    "sbt.project.name" -> "java8-tests"
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
        "org.apache.maven.plugins" % "maven-surefire-plugin",
        executions = Seq(
          Execution(
            id = "test",
            goals = Seq(
              "test"
            )
          )
        ),
        configuration = Config(
          systemPropertyVariables = Config(
            log4j.configuration = "file:src/test/resources/log4j.properties"
          ),
          skipTests = "false",
          includes = Config(
            include = "**/Suite*.java",
            include = "**/*Suite.java"
          )
        )
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-compiler-plugin",
        executions = Seq(
          Execution(
            id = "test-compile-first",
            phase = "process-test-resources",
            goals = Seq(
              "testCompile"
            )
          )
        ),
        configuration = Config(
          fork = "true",
          verbose = "true",
          forceJavacCompilerUse = "true",
          source = "1.8",
          compilerVersion = "1.8",
          target = "1.8",
          encoding = "UTF-8",
          maxmem = "1024m"
        )
      ),
      Plugin(
        "net.alchim31.maven" % "scala-maven-plugin",
        executions = Seq(
          Execution(
            phase = "none"
          ),
          Execution(
            id = "scala-compile-first",
            phase = "none"
          ),
          Execution(
            id = "scala-test-compile-first",
            phase = "none"
          ),
          Execution(
            id = "attach-scaladocs",
            phase = "none"
          )
        )
      )
    )
  ),
  profiles = Seq(
    Profile(
      id = "java8-tests"
    )
  ),
  modelVersion = "4.0.0"
)
