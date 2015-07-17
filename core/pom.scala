import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-core",
  name = "Spark Project Core",
  url = "http://spark.apache.org/",
  parent = Parent(
    gav = "org.apache.spark" %% "spark-parent" % "1.5.0-SNAPSHOT",
    relativePath = "../pom.scala"
  ),
  dependencies = Seq(
    "com.google.guava" % "guava" % "",
    Dependency(
      "com.twitter" %% "chill",
      exclusions = Seq(
        "org.ow2.asm" % "asm",
        "org.ow2.asm" % "asm-commons"
      )
    ),
    Dependency(
      "com.twitter" % "chill-java",
      exclusions = Seq(
        "org.ow2.asm" % "asm",
        "org.ow2.asm" % "asm-commons"
      )
    ),
    "org.apache.hadoop" % "hadoop-client" % "",
    "org.apache.spark" %% "spark-launcher" % "${project.version}",
    "org.apache.spark" %% "spark-network-common" % "${project.version}",
    "org.apache.spark" %% "spark-network-shuffle" % "${project.version}",
    "org.apache.spark" %% "spark-unsafe" % "${project.version}",
    "net.java.dev.jets3t" % "jets3t" % "",
    "org.apache.curator" % "curator-recipes" % "",
    "org.eclipse.jetty" % "jetty-plus" % "" % "compile",
    "org.eclipse.jetty" % "jetty-security" % "" % "compile",
    "org.eclipse.jetty" % "jetty-util" % "" % "compile",
    "org.eclipse.jetty" % "jetty-server" % "" % "compile",
    "org.eclipse.jetty" % "jetty-http" % "" % "compile",
    "org.eclipse.jetty" % "jetty-continuation" % "" % "compile",
    "org.eclipse.jetty" % "jetty-servlet" % "" % "compile",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "${orbit.version}",
    "org.apache.commons" % "commons-lang3" % "",
    "org.apache.commons" % "commons-math3" % "",
    "com.google.code.findbugs" % "jsr305" % "",
    "org.slf4j" % "slf4j-api" % "",
    "org.slf4j" % "jul-to-slf4j" % "",
    "org.slf4j" % "jcl-over-slf4j" % "",
    "log4j" % "log4j" % "",
    "org.slf4j" % "slf4j-log4j12" % "",
    "com.ning" % "compress-lzf" % "",
    "org.xerial.snappy" % "snappy-java" % "",
    "net.jpountz.lz4" % "lz4" % "",
    "org.roaringbitmap" % "RoaringBitmap" % "",
    "commons-net" % "commons-net" % "",
    "${akka.group}" %% "akka-remote" % "",
    "${akka.group}" %% "akka-slf4j" % "",
    "${akka.group}" %% "akka-testkit" % "" % "test",
    "org.scala-lang" % "scala-library" % "",
    "org.json4s" %% "json4s-jackson" % "3.2.10",
    "com.sun.jersey" % "jersey-server" % "",
    "com.sun.jersey" % "jersey-core" % "",
    Dependency(
      "org.apache.mesos" % "mesos",
      classifier = "${mesos.classifier}"
    ),
    "io.netty" % "netty-all" % "",
    "com.clearspring.analytics" % "stream" % "",
    "io.dropwizard.metrics" % "metrics-core" % "",
    "io.dropwizard.metrics" % "metrics-jvm" % "",
    "io.dropwizard.metrics" % "metrics-json" % "",
    "io.dropwizard.metrics" % "metrics-graphite" % "",
    "com.fasterxml.jackson.core" % "jackson-databind" % "",
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "",
    "org.apache.derby" % "derby" % "" % "test",
    "org.apache.ivy" % "ivy" % "",
    "oro" % "oro" % "${oro.version}",
    Dependency(
      "org.tachyonproject" % "tachyon-client" % "0.6.4",
      exclusions = Seq(
        "org.apache.hadoop" % "hadoop-client",
        "org.apache.curator" % "curator-recipes",
        "org.eclipse.jetty" % "jetty-jsp",
        "org.eclipse.jetty" % "jetty-webapp",
        "org.eclipse.jetty" % "jetty-server",
        "org.eclipse.jetty" % "jetty-servlet",
        "junit" % "junit",
        "org.powermock" % "powermock-module-junit4",
        "org.powermock" % "powermock-api-mockito",
        "org.apache.curator" % "curator-test"
      )
    ),
    Dependency(
      "org.seleniumhq.selenium" % "selenium-java",
      scope = "test",
      exclusions = Seq(
        "com.google.guava" % "guava"
      )
    ),
    "xml-apis" % "xml-apis" % "" % "test",
    "org.hamcrest" % "hamcrest-core" % "" % "test",
    "org.hamcrest" % "hamcrest-library" % "" % "test",
    "org.mockito" % "mockito-core" % "" % "test",
    "org.scalacheck" %% "scalacheck" % "" % "test",
    "junit" % "junit" % "" % "test",
    "com.novocode" % "junit-interface" % "" % "test",
    Dependency(
      "net.razorvine" % "pyrolite" % "4.4",
      exclusions = Seq(
        "net.razorvine" % "serpent"
      )
    ),
    "net.sf.py4j" % "py4j" % "0.8.2.1"
  ),
  properties = Map(
    "sbt.project.name" -> "core"
  ),
  build = Build(
    outputDirectory = "target/scala-${scala.binary.version}/classes",
    testOutputDirectory = "target/scala-${scala.binary.version}/test-classes",
    plugins = Seq(
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
              outputDirectory = "${project.build.directory}",
              overWriteReleases = "false",
              overWriteSnapshots = "false",
              overWriteIfNewer = "true",
              useSubDirectoryPerType = "true",
              includeArtifactIds = "guava,jetty-io,jetty-servlet,jetty-continuation,jetty-http,jetty-plus,jetty-util,jetty-server,jetty-security",
              silent = "true"
            )
          )
        )
      )
    )
  ),
  profiles = Seq(
    Profile(
      id = "Windows",
      activation = Activation(
        os = ActivationOS(
          family = "Windows"
        )
      )
    ),
    Profile(
      id = "unix",
      activation = Activation(
        os = ActivationOS(
          family = "unix"
        )
      )
    ),
    Profile(
      id = "sparkr",
      build = BuildBase(
        plugins = Seq(
          Plugin(
            "org.codehaus.mojo" % "exec-maven-plugin",
            executions = Seq(
              Execution(
                id = "sparkr-pkg",
                phase = "compile",
                goals = Seq(
                  "exec"
                )
              )
            ),
            configuration = Config(
              executable = "..${path.separator}R${path.separator}install-dev${script.extension}"
            )
          )
        )
      )
    )
  ),
  modelVersion = "4.0.0"
)
