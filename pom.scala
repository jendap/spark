import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

implicit val scalaVersion = ScalaVersion(System.getProperty("foo", "2.10.5"))

Model(
  "org.apache.spark" %% "spark-parent" % "1.5.0-SNAPSHOT",
  packaging = "pom",
  name = "Spark Project Parent POM",
  url = "http://spark.apache.org/",
  prerequisites = Prerequisites(
    maven = "3.0.4"
  ),
  issueManagement = IssueManagement(
    system = "JIRA",
    url = "https://issues.apache.org/jira/browse/SPARK"
  ),
  mailingLists = Seq(
    MailingList(
      name = "Dev Mailing List",
      subscribe = "dev-subscribe@spark.apache.org",
      unsubscribe = "dev-unsubscribe@spark.apache.org",
      post = "dev@spark.apache.org"
    ),
    MailingList(
      name = "User Mailing List",
      subscribe = "user-subscribe@spark.apache.org",
      unsubscribe = "user-unsubscribe@spark.apache.org",
      post = "user@spark.apache.org"
    ),
    MailingList(
      name = "Commits Mailing List",
      subscribe = "commits-subscribe@spark.apache.org",
      unsubscribe = "commits-unsubscribe@spark.apache.org",
      post = "commits@spark.apache.org"
    )
  ),
  developers = Seq(
    Developer(
      id = "matei",
      email = "matei.zaharia@gmail.com",
      name = "Matei Zaharia",
      organization = "Apache Software Foundation",
      organizationUrl = "http://spark.apache.org",
      url = "http://www.cs.berkeley.edu/~matei"
    )
  ),
  licenses = Seq(
    License(
      name = "Apache 2.0 License",
      url = "http://www.apache.org/licenses/LICENSE-2.0.html",
      distribution = "repo"
    )
  ),
  scm = Scm(
    connection = "scm:git:git@github.com:apache/spark.git",
    developerConnection = "scm:git:https://git-wip-us.apache.org/repos/asf/spark.git",
    url = "scm:git:git@github.com:apache/spark.git"
  ),
  parent = Parent(
    gav = "org.apache" % "apache" % "14"
  ),
  modules = Seq(
    "core",
    "bagel",
    "graphx",
    "mllib",
    "tools",
    "network/common",
    "network/shuffle",
    "streaming",
    "sql/catalyst",
    "sql/core",
    "sql/hive",
    "unsafe",
    "assembly",
    "external/twitter",
    "external/flume",
    "external/flume-sink",
    "external/flume-assembly",
    "external/mqtt",
    "external/zeromq",
    "examples",
    "repl",
    "launcher",
    "external/kafka",
    "external/kafka-assembly"
  ),
  repositories = Seq(
    Repository(
      releases = RepositoryPolicy(
        enabled = true
      ),
      snapshots = RepositoryPolicy(
        enabled = false
      ),
      id = "central",
      name = "Maven Repository",
      url = "https://repo1.maven.org/maven2"
    ),
    Repository(
      releases = RepositoryPolicy(
        enabled = true
      ),
      snapshots = RepositoryPolicy(
        enabled = false
      ),
      id = "apache-repo",
      name = "Apache Repository",
      url = "https://repository.apache.org/content/repositories/releases"
    ),
    Repository(
      releases = RepositoryPolicy(
        enabled = true
      ),
      snapshots = RepositoryPolicy(
        enabled = false
      ),
      id = "jboss-repo",
      name = "JBoss Repository",
      url = "https://repository.jboss.org/nexus/content/repositories/releases"
    ),
    Repository(
      releases = RepositoryPolicy(
        enabled = true
      ),
      snapshots = RepositoryPolicy(
        enabled = false
      ),
      id = "mqtt-repo",
      name = "MQTT Repository",
      url = "https://repo.eclipse.org/content/repositories/paho-releases"
    ),
    Repository(
      releases = RepositoryPolicy(
        enabled = true
      ),
      snapshots = RepositoryPolicy(
        enabled = false
      ),
      id = "cloudera-repo",
      name = "Cloudera Repository",
      url = "https://repository.cloudera.com/artifactory/cloudera-repos"
    ),
    Repository(
      releases = RepositoryPolicy(
        enabled = true
      ),
      snapshots = RepositoryPolicy(
        enabled = false
      ),
      id = "mapr-repo",
      name = "MapR Repository",
      url = "http://repository.mapr.com/maven/"
    ),
    Repository(
      releases = RepositoryPolicy(
        enabled = true
      ),
      snapshots = RepositoryPolicy(
        enabled = false
      ),
      id = "spring-releases",
      name = "Spring Release Repository",
      url = "https://repo.spring.io/libs-release"
    ),
    Repository(
      releases = RepositoryPolicy(
        enabled = true
      ),
      snapshots = RepositoryPolicy(
        enabled = false
      ),
      id = "twttr-repo",
      name = "Twttr Repository",
      url = "http://maven.twttr.com"
    )
  ),
  pluginRepositories = Seq(
    Repository(
      releases = RepositoryPolicy(
        enabled = true
      ),
      snapshots = RepositoryPolicy(
        enabled = false
      ),
      id = "central",
      url = "https://repo1.maven.org/maven2"
    )
  ),
  dependencies = Seq(
    "org.spark-project.spark" % "unused" % "1.0.0",
    "org.scalatest" %% "scalatest" % "" % "test"
  ),
  dependencyManagement = DependencyManagement(
    dependencies = Seq(
      Dependency(
        "com.twitter" %% "chill" % "${chill.version}",
        exclusions = Seq(
          "org.ow2.asm" % "asm",
          "org.ow2.asm" % "asm-commons"
        )
      ),
      Dependency(
        "com.twitter" % "chill-java" % "${chill.version}",
        exclusions = Seq(
          "org.ow2.asm" % "asm",
          "org.ow2.asm" % "asm-commons"
        )
      ),
      "org.eclipse.jetty" % "jetty-http" % "${jetty.version}" % "provided",
      "org.eclipse.jetty" % "jetty-continuation" % "${jetty.version}" % "provided",
      "org.eclipse.jetty" % "jetty-servlet" % "${jetty.version}" % "provided",
      "org.eclipse.jetty" % "jetty-util" % "${jetty.version}" % "provided",
      "org.eclipse.jetty" % "jetty-security" % "${jetty.version}" % "provided",
      "org.eclipse.jetty" % "jetty-plus" % "${jetty.version}" % "provided",
      "org.eclipse.jetty" % "jetty-server" % "${jetty.version}" % "provided",
      "com.google.guava" % "guava" % "14.0.1" % "provided",
      "org.apache.commons" % "commons-lang3" % "3.3.2",
      "commons-codec" % "commons-codec" % "1.10",
      "org.apache.commons" % "commons-math3" % "${commons.math3.version}",
      "org.apache.ivy" % "ivy" % "${ivy.version}",
      "com.google.code.findbugs" % "jsr305" % "1.3.9",
      "org.apache.httpcomponents" % "httpclient" % "${commons.httpclient.version}",
      "org.apache.httpcomponents" % "httpcore" % "${commons.httpclient.version}",
      "org.seleniumhq.selenium" % "selenium-java" % "2.42.2" % "test",
      "xml-apis" % "xml-apis" % "1.4.01" % "test",
      "org.slf4j" % "slf4j-api" % "${slf4j.version}" % "${hadoop.deps.scope}",
      "org.slf4j" % "slf4j-log4j12" % "${slf4j.version}" % "${hadoop.deps.scope}",
      "org.slf4j" % "jul-to-slf4j" % "${slf4j.version}",
      "org.slf4j" % "jcl-over-slf4j" % "${slf4j.version}",
      "log4j" % "log4j" % "${log4j.version}" % "${hadoop.deps.scope}",
      "com.ning" % "compress-lzf" % "1.0.3",
      "org.xerial.snappy" % "snappy-java" % "${snappy.version}" % "${hadoop.deps.scope}",
      "net.jpountz.lz4" % "lz4" % "1.3.0",
      Dependency(
        "com.clearspring.analytics" % "stream" % "2.7.0",
        exclusions = Seq(
          "it.unimi.dsi" % "fastutil"
        )
      ),
      "com.google.protobuf" % "protobuf-java" % "${protobuf.version}" % "${hadoop.deps.scope}",
      "${akka.group}" %% "akka-actor" % "${akka.version}",
      "${akka.group}" %% "akka-remote" % "${akka.version}",
      "${akka.group}" %% "akka-slf4j" % "${akka.version}",
      "${akka.group}" %% "akka-testkit" % "${akka.version}",
      Dependency(
        "${akka.group}" %% "akka-zeromq" % "${akka.version}",
        exclusions = Seq(
          "${akka.group}" %% "akka-actor"
        )
      ),
      Dependency(
        "org.apache.mesos" % "mesos" % "${mesos.version}",
        classifier = "${mesos.classifier}",
        exclusions = Seq(
          "com.google.protobuf" % "protobuf-java"
        )
      ),
      "org.roaringbitmap" % "RoaringBitmap" % "0.4.5",
      "commons-net" % "commons-net" % "2.2",
      "io.netty" % "netty-all" % "4.0.28.Final",
      "org.apache.derby" % "derby" % "${derby.version}",
      "io.dropwizard.metrics" % "metrics-core" % "${codahale.metrics.version}",
      "io.dropwizard.metrics" % "metrics-jvm" % "${codahale.metrics.version}",
      "io.dropwizard.metrics" % "metrics-json" % "${codahale.metrics.version}",
      "io.dropwizard.metrics" % "metrics-ganglia" % "${codahale.metrics.version}",
      "io.dropwizard.metrics" % "metrics-graphite" % "${codahale.metrics.version}",
      "com.fasterxml.jackson.core" % "jackson-databind" % "${fasterxml.jackson.version}",
      Dependency(
        "com.fasterxml.jackson.module" %% "jackson-module-scala" % "${fasterxml.jackson.version}",
        exclusions = Seq(
          "com.google.guava" % "guava"
        )
      ),
      "com.sun.jersey" % "jersey-server" % "1.9" % "${hadoop.deps.scope}",
      "com.sun.jersey" % "jersey-core" % "1.9" % "${hadoop.deps.scope}",
      "org.scala-lang" % "scala-compiler" % "${scala.version}",
      "org.scala-lang" % "scala-reflect" % "${scala.version}",
      "org.scala-lang" % "scala-library" % "${scala.version}",
      "org.scala-lang" % "scala-actors" % "${scala.version}",
      "org.scala-lang" % "scalap" % "${scala.version}",
      "org.scalatest" %% "scalatest" % "2.2.1" % "test",
      "org.mockito" % "mockito-core" % "1.9.5" % "test",
      "org.scalacheck" %% "scalacheck" % "1.11.3" % "test",
      "junit" % "junit" % "4.10" % "test",
      "org.hamcrest" % "hamcrest-core" % "1.3" % "test",
      "org.hamcrest" % "hamcrest-library" % "1.3" % "test",
      "com.novocode" % "junit-interface" % "0.10" % "test",
      Dependency(
        "org.apache.curator" % "curator-recipes" % "${curator.version}",
        scope = "${hadoop.deps.scope}",
        exclusions = Seq(
          "org.jboss.netty" % "netty"
        )
      ),
      "org.apache.curator" % "curator-client" % "${curator.version}",
      "org.apache.curator" % "curator-framework" % "${curator.version}",
      Dependency(
        "org.apache.hadoop" % "hadoop-client" % "${hadoop.version}",
        scope = "${hadoop.deps.scope}",
        exclusions = Seq(
          "asm" % "asm",
          "org.codehaus.jackson" % "jackson-mapper-asl",
          "org.ow2.asm" % "asm",
          "org.jboss.netty" % "netty",
          "commons-logging" % "commons-logging",
          "org.mockito" % "mockito-all",
          "org.mortbay.jetty" % "servlet-api-2.5",
          "javax.servlet" % "servlet-api",
          "junit" % "junit"
        )
      ),
      "org.apache.avro" % "avro" % "${avro.version}" % "${hadoop.deps.scope}",
      Dependency(
        "org.apache.avro" % "avro-ipc" % "${avro.version}",
        scope = "${hadoop.deps.scope}",
        exclusions = Seq(
          "io.netty" % "netty",
          "org.mortbay.jetty" % "jetty",
          "org.mortbay.jetty" % "jetty-util",
          "org.mortbay.jetty" % "servlet-api",
          "org.apache.velocity" % "velocity"
        )
      ),
      Dependency(
        "org.apache.avro" % "avro-mapred" % "${avro.version}",
        classifier = "${avro.mapred.classifier}",
        scope = "${hive.deps.scope}",
        exclusions = Seq(
          "io.netty" % "netty",
          "org.mortbay.jetty" % "jetty",
          "org.mortbay.jetty" % "jetty-util",
          "org.mortbay.jetty" % "servlet-api",
          "org.apache.velocity" % "velocity"
        )
      ),
      Dependency(
        "net.java.dev.jets3t" % "jets3t" % "${jets3t.version}",
        scope = "${hadoop.deps.scope}",
        exclusions = Seq(
          "commons-logging" % "commons-logging"
        )
      ),
      Dependency(
        "org.apache.hadoop" % "hadoop-yarn-api" % "${yarn.version}",
        scope = "${hadoop.deps.scope}",
        exclusions = Seq(
          "javax.servlet" % "servlet-api",
          "asm" % "asm",
          "org.ow2.asm" % "asm",
          "org.jboss.netty" % "netty",
          "commons-logging" % "commons-logging"
        )
      ),
      Dependency(
        "org.apache.hadoop" % "hadoop-yarn-common" % "${yarn.version}",
        scope = "${hadoop.deps.scope}",
        exclusions = Seq(
          "asm" % "asm",
          "org.ow2.asm" % "asm",
          "org.jboss.netty" % "netty",
          "javax.servlet" % "servlet-api",
          "commons-logging" % "commons-logging"
        )
      ),
      Dependency(
        "org.apache.hadoop" % "hadoop-yarn-server-tests" % "${yarn.version}",
        classifier = "tests",
        scope = "test",
        exclusions = Seq(
          "asm" % "asm",
          "org.ow2.asm" % "asm",
          "org.jboss.netty" % "netty",
          "javax.servlet" % "servlet-api",
          "commons-logging" % "commons-logging"
        )
      ),
      Dependency(
        "org.apache.hadoop" % "hadoop-yarn-server-web-proxy" % "${yarn.version}",
        scope = "${hadoop.deps.scope}",
        exclusions = Seq(
          "asm" % "asm",
          "org.ow2.asm" % "asm",
          "org.jboss.netty" % "netty",
          "javax.servlet" % "servlet-api",
          "commons-logging" % "commons-logging"
        )
      ),
      Dependency(
        "org.apache.hadoop" % "hadoop-yarn-client" % "${yarn.version}",
        scope = "${hadoop.deps.scope}",
        exclusions = Seq(
          "asm" % "asm",
          "org.ow2.asm" % "asm",
          "org.jboss.netty" % "netty",
          "javax.servlet" % "servlet-api",
          "commons-logging" % "commons-logging"
        )
      ),
      "org.apache.zookeeper" % "zookeeper" % "${zookeeper.version}" % "${hadoop.deps.scope}",
      "org.codehaus.jackson" % "jackson-core-asl" % "${codehaus.jackson.version}" % "${hadoop.deps.scope}",
      "org.codehaus.jackson" % "jackson-mapper-asl" % "${codehaus.jackson.version}" % "${hadoop.deps.scope}",
      "org.codehaus.jackson" % "jackson-xc" % "${codehaus.jackson.version}",
      "org.codehaus.jackson" % "jackson-jaxrs" % "${codehaus.jackson.version}",
      "${hive.group}" % "hive-beeline" % "${hive.version}" % "${hive.deps.scope}",
      "${hive.group}" % "hive-cli" % "${hive.version}" % "${hive.deps.scope}",
      Dependency(
        "${hive.group}" % "hive-exec" % "${hive.version}",
        scope = "${hive.deps.scope}",
        exclusions = Seq(
          "commons-logging" % "commons-logging",
          "com.esotericsoftware.kryo" % "kryo",
          "org.apache.avro" % "avro-mapred"
        )
      ),
      "${hive.group}" % "hive-jdbc" % "${hive.version}" % "${hive.deps.scope}",
      "${hive.group}" % "hive-metastore" % "${hive.version}" % "${hive.deps.scope}",
      Dependency(
        "${hive.group}" % "hive-serde" % "${hive.version}",
        scope = "${hive.deps.scope}",
        exclusions = Seq(
          "commons-logging" % "commons-logging",
          "commons-logging" % "commons-logging-api"
        )
      ),
      "org.apache.parquet" % "parquet-column" % "${parquet.version}" % "${parquet.deps.scope}",
      "org.apache.parquet" % "parquet-hadoop" % "${parquet.version}" % "${parquet.deps.scope}",
      "org.apache.parquet" % "parquet-avro" % "${parquet.version}" % "${parquet.test.deps.scope}",
      Dependency(
        "org.apache.flume" % "flume-ng-core" % "${flume.version}",
        scope = "${flume.deps.scope}",
        exclusions = Seq(
          "io.netty" % "netty",
          "org.apache.flume" % "flume-ng-auth",
          "org.apache.thrift" % "libthrift",
          "org.mortbay.jetty" % "servlet-api"
        )
      ),
      Dependency(
        "org.apache.flume" % "flume-ng-sdk" % "${flume.version}",
        scope = "${flume.deps.scope}",
        exclusions = Seq(
          "io.netty" % "netty",
          "org.apache.thrift" % "libthrift"
        )
      )
    )
  ),
  properties = Map(
    "yarn.version" -> "${hadoop.version}",
    "avro.mapred.classifier" -> "hadoop2",
    "parquet.version" -> "1.7.0",
    "snappy.version" -> "1.1.1.7",
    "fasterxml.jackson.version" -> "2.4.4",
    "project.build.sourceEncoding" -> "UTF-8",
    "flume.deps.scope" -> "compile",
    "hadoop.version" -> "2.2.0",
    "jets3t.version" -> "0.7.1",
    "jline.groupid" -> "org.scala-lang",
    "hbase.artifact" -> "hbase",
    "create.dependency.reduced.pom" -> "false",
    "chill.version" -> "0.5.0",
    "jline.version" -> "${scala.version}",
    "MaxPermGen" -> "512m",
    "mesos.classifier" -> "shaded-protobuf",
    "orbit.version" -> "3.0.0.v201112011016",
    "commons.math3.version" -> "3.4.1",
    "flume.version" -> "1.4.0",
    "derby.version" -> "10.10.1.1",
    "netlib.java.version" -> "1.1.2",
    "aws.kinesis.client.version" -> "1.2.1",
    "scala.binary.version" -> "2.10",
    "PermGen" -> "64m",
    "codahale.metrics.version" -> "3.1.0",
    "curator.version" -> "2.4.0",
    "log4j.version" -> "1.2.17",
    "hive.version" -> "0.13.1a",
    "test.java.home" -> "${java.home}",
    "jblas.version" -> "1.2.4",
    "commons.httpclient.version" -> "4.3.2",
    "oro.version" -> "2.0.8",
    "parquet.test.deps.scope" -> "test",
    "sbt.project.name" -> "spark",
    "hadoop.deps.scope" -> "compile",
    "hbase.deps.scope" -> "compile",
    "hive.version.short" -> "0.13.1",
    "akka.group" -> "com.typesafe.akka",
    "hive.deps.scope" -> "compile",
    "hbase.version" -> "0.98.7-hadoop2",
    "slf4j.version" -> "1.7.10",
    "parquet.deps.scope" -> "compile",
    "akka.version" -> "2.3.11",
    "mesos.version" -> "0.21.1",
    "protobuf.version" -> "2.5.0",
    "hive.group" -> "org.spark-project.hive",
    "aws.java.sdk.version" -> "1.9.16",
    "codehaus.jackson.version" -> "1.9.13",
    "spark.test.home" -> "${session.executionRootDirectory}",
    "CodeCacheSize" -> "512m",
    "scala.version" -> "2.10.4",
    "zookeeper.version" -> "3.4.5",
    "avro.version" -> "1.7.7",
    "ivy.version" -> "2.4.0",
    "jetty.version" -> "8.1.14.v20131031",
    "project.reporting.outputEncoding" -> "UTF-8",
    "java.version" -> "1.7"
  ),
  build = Build(
    pluginManagement = PluginManagement(
      plugins = Seq(
        Plugin(
          "org.apache.maven.plugins" % "maven-enforcer-plugin" % "1.4",
          executions = Seq(
            Execution(
              id = "enforce-versions",
              goals = Seq(
                "enforce"
              ),
              configuration = Config(
                rules = Config(
                  requireMavenVersion = Config(
                    version = "3.0.4"
                  ),
                  requireJavaVersion = Config(
                    version = "${java.version}"
                  )
                )
              )
            )
          )
        ),
        Plugin(
          "org.codehaus.mojo" % "build-helper-maven-plugin" % "1.9.1"
        ),
        Plugin(
          "net.alchim31.maven" % "scala-maven-plugin" % "3.2.0",
          executions = Seq(
            Execution(
              id = "eclipse-add-source",
              goals = Seq(
                "add-source"
              )
            ),
            Execution(
              id = "scala-compile-first",
              phase = "process-resources",
              goals = Seq(
                "compile"
              )
            ),
            Execution(
              id = "scala-test-compile-first",
              phase = "process-test-resources",
              goals = Seq(
                "testCompile"
              )
            ),
            Execution(
              id = "attach-scaladocs",
              phase = "verify",
              goals = Seq(
                "doc-jar"
              )
            )
          ),
          configuration = Config(
            scalaVersion = "${scala.version}",
            recompileMode = "incremental",
            useZincServer = "true",
            args = Config(
              arg = "-unchecked",
              arg = "-deprecation",
              arg = "-feature"
            ),
            jvmArgs = Config(
              jvmArg = "-Xms1024m",
              jvmArg = "-Xmx1024m",
              jvmArg = "-XX:PermSize=${PermGen}",
              jvmArg = "-XX:MaxPermSize=${MaxPermGen}",
              jvmArg = "-XX:ReservedCodeCacheSize=${CodeCacheSize}"
            ),
            javacArgs = Config(
              javacArg = "-source",
              javacArg = "${java.version}",
              javacArg = "-target",
              javacArg = "${java.version}"
            )
          )
        ),
        Plugin(
          "org.apache.maven.plugins" % "maven-compiler-plugin" % "3.3",
          configuration = Config(
            source = "${java.version}",
            target = "${java.version}",
            encoding = "UTF-8",
            maxmem = "1024m",
            fork = "true"
          )
        ),
        Plugin(
          "org.apache.maven.plugins" % "maven-surefire-plugin" % "2.18.1",
          configuration = Config(
            includes = Config(
              include = "**/Test*.java",
              include = "**/*Test.java",
              include = "**/*TestCase.java",
              include = "**/*Suite.java"
            ),
            reportsDirectory = "${project.build.directory}/surefire-reports",
            argLine = "-Xmx3g -Xss4096k -XX:MaxPermSize=${MaxPermGen} -XX:ReservedCodeCacheSize=512m",
            environmentVariables = Config(
              SPARK_DIST_CLASSPATH = "${test_classpath}",
              JAVA_HOME = "${test.java.home}"
            ),
            systemProperties = Config(
              `derby.system.durability` = "test",
              `java.awt.headless` = "true",
              `java.io.tmpdir` = "${project.build.directory}/tmp",
              `spark.test.home` = "${spark.test.home}",
              `spark.testing` = "1",
              `spark.ui.enabled` = "false",
              `spark.ui.showConsoleProgress` = "false",
              `spark.driver.allowMultipleContexts` = "true",
              `spark.unsafe.exceptionOnMemoryLeak` = "true"
            ),
            failIfNoTests = "false"
          )
        ),
        Plugin(
          "org.scalatest" % "scalatest-maven-plugin" % "1.0",
          executions = Seq(
            Execution(
              id = "test",
              goals = Seq(
                "test"
              )
            )
          ),
          configuration = Config(
            reportsDirectory = "${project.build.directory}/surefire-reports",
            junitxml = ".",
            filereports = "SparkTestSuite.txt",
            argLine = "-ea -Xmx3g -XX:MaxPermSize=${MaxPermGen} -XX:ReservedCodeCacheSize=${CodeCacheSize}",
            stderr = None,
            environmentVariables = Config(
              SPARK_DIST_CLASSPATH = "${test_classpath}",
              JAVA_HOME = "${test.java.home}"
            ),
            systemProperties = Config(
              `derby.system.durability` = "test",
              `java.awt.headless` = "true",
              `java.io.tmpdir` = "${project.build.directory}/tmp",
              `spark.test.home` = "${spark.test.home}",
              `spark.testing` = "1",
              `spark.ui.enabled` = "false",
              `spark.ui.showConsoleProgress` = "false",
              `spark.driver.allowMultipleContexts` = "true",
              `spark.unsafe.exceptionOnMemoryLeak` = "true"
            )
          )
        ),
        Plugin(
          "org.apache.maven.plugins" % "maven-jar-plugin" % "2.6"
        ),
        Plugin(
          "org.apache.maven.plugins" % "maven-antrun-plugin" % "1.8"
        ),
        Plugin(
          "org.apache.maven.plugins" % "maven-source-plugin" % "2.4",
          executions = Seq(
            Execution(
              id = "create-source-jar",
              goals = Seq(
                "jar-no-fork",
                "test-jar-no-fork"
              )
            )
          ),
          configuration = Config(
            attach = "true"
          )
        ),
        Plugin(
          "org.apache.maven.plugins" % "maven-clean-plugin" % "2.6.1",
          configuration = Config(
            filesets = Config(
              fileset = Config(
                directory = "work"
              ),
              fileset = Config(
                directory = "checkpoint"
              ),
              fileset = Config(
                directory = "lib_managed"
              )
            )
          )
        ),
        Plugin(
          "org.apache.maven.plugins" % "maven-javadoc-plugin" % "2.10.3"
        ),
        Plugin(
          "org.codehaus.mojo" % "exec-maven-plugin" % "1.4.0"
        ),
        Plugin(
          "org.apache.maven.plugins" % "maven-assembly-plugin" % "2.5.3"
        ),
        Plugin(
          "org.apache.maven.plugins" % "maven-install-plugin" % "2.5.2"
        ),
        Plugin(
          "org.apache.maven.plugins" % "maven-deploy-plugin" % "2.8.2"
        ),
        Plugin(
          "org.eclipse.m2e" % "lifecycle-mapping" % "1.0.0",
          configuration = Config(
            lifecycleMappingMetadata = Config(
              pluginExecutions = Config(
                pluginExecution = Config(
                  pluginExecutionFilter = Config(
                    groupId = "org.apache.maven.plugins",
                    artifactId = "maven-dependency-plugin",
                    versionRange = "[2.8,)",
                    goals = Config(
                      goal = "build-classpath"
                    )
                  ),
                  action = Config(
                    ignore = ""
                  )
                ),
                pluginExecution = Config(
                  pluginExecutionFilter = Config(
                    groupId = "org.apache.maven.plugins",
                    artifactId = "maven-jar-plugin",
                    versionRange = "[2.6,)",
                    goals = Config(
                      goal = "test-jar"
                    )
                  ),
                  action = Config(
                    ignore = ""
                  )
                ),
                pluginExecution = Config(
                  pluginExecutionFilter = Config(
                    groupId = "org.apache.maven.plugins",
                    artifactId = "maven-antrun-plugin",
                    versionRange = "[1.8,)",
                    goals = Config(
                      goal = "run"
                    )
                  ),
                  action = Config(
                    ignore = ""
                  )
                )
              )
            )
          )
        )
      )
    ),
    plugins = Seq(
      Plugin(
        "org.apache.maven.plugins" % "maven-dependency-plugin" % "2.10",
        executions = Seq(
          Execution(
            phase = "test-compile",
            goals = Seq(
              "build-classpath"
            ),
            configuration = Config(
              includeScope = "test",
              outputProperty = "test_classpath"
            )
          )
        )
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-shade-plugin" % "2.3",
        executions = Seq(
          Execution(
            phase = "package",
            goals = Seq(
              "shade"
            )
          )
        ),
        configuration = Config(
          shadedArtifactAttached = "false",
          createDependencyReducedPom = "${create.dependency.reduced.pom}",
          artifactSet = Config(
            includes = Config(
              include = "org.spark-project.spark:unused",
              include = "org.eclipse.jetty:jetty-io",
              include = "org.eclipse.jetty:jetty-http",
              include = "org.eclipse.jetty:jetty-continuation",
              include = "org.eclipse.jetty:jetty-servlet",
              include = "org.eclipse.jetty:jetty-plus",
              include = "org.eclipse.jetty:jetty-security",
              include = "org.eclipse.jetty:jetty-util",
              include = "org.eclipse.jetty:jetty-server",
              include = "com.google.guava:guava"
            )
          ),
          relocations = Config(
            relocation = Config(
              pattern = "org.eclipse.jetty",
              shadedPattern = "org.spark-project.jetty",
              includes = Config(
                include = "org.eclipse.jetty.**"
              )
            ),
            relocation = Config(
              pattern = "com.google.common",
              shadedPattern = "org.spark-project.guava",
              excludes = Config(
                exclude = "com/google/common/base/Absent*",
                exclude = "com/google/common/base/Function",
                exclude = "com/google/common/base/Optional*",
                exclude = "com/google/common/base/Present*",
                exclude = "com/google/common/base/Supplier"
              )
            )
          )
        )
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-enforcer-plugin"
      ),
      Plugin(
        "net.alchim31.maven" % "scala-maven-plugin"
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-source-plugin"
      ),
      Plugin(
        "org.scalastyle" % "scalastyle-maven-plugin" % "0.7.0",
        executions = Seq(
          Execution(
            goals = Seq(
              "check"
            )
          )
        ),
        configuration = Config(
          verbose = "false",
          failOnViolation = "true",
          includeTestSourceDirectory = "false",
          failOnWarning = "false",
          sourceDirectory = "${basedir}/src/main/scala",
          testSourceDirectory = "${basedir}/src/test/scala",
          configLocation = "scalastyle-config.xml",
          outputFile = "${basedir}/target/scalastyle-output.xml",
          inputEncoding = "${project.build.sourceEncoding}",
          outputEncoding = "${project.reporting.outputEncoding}"
        )
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-antrun-plugin",
        executions = Seq(
          Execution(
            id = "create-tmp-dir",
            phase = "generate-test-resources",
            goals = Seq(
              "run"
            ),
            configuration = Config(
              target = Config(
                mkdir = Config(
                  `@dir` = "${project.build.directory}/tmp"
                )
              )
            )
          )
        )
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-surefire-plugin"
      ),
      Plugin(
        "org.scalatest" % "scalatest-maven-plugin"
      ),
      Plugin(
        "org.apache.maven.plugins" % "maven-jar-plugin",
        executions = Seq(
          Execution(
            id = "prepare-test-jar",
            phase = "prepare-package",
            goals = Seq(
              "test-jar"
            ),
            configuration = Config(
              excludes = Config(
                exclude = "log4j.properties"
              )
            )
          )
        )
      )
    )
  ),
  profiles = Seq(
    Profile(
      id = "sbt",
      dependencies = Seq(
        "com.google.guava" % "guava" % "" % "compile"
      )
    ),
    Profile(
      id = "spark-ganglia-lgpl",
      modules = Seq(
        "extras/spark-ganglia-lgpl"
      )
    ),
    Profile(
      id = "kinesis-asl",
      modules = Seq(
        "extras/kinesis-asl"
      )
    ),
    Profile(
      id = "java8-tests",
      build = BuildBase(
        plugins = Seq(
          Plugin(
            "org.apache.maven.plugins" % "maven-jar-plugin",
            executions = Seq(
              Execution(
                goals = Seq(
                  "test-jar"
                )
              )
            )
          )
        )
      ),
      modules = Seq(
        "extras/java8-tests"
      )
    ),
    Profile(
      id = "doclint-java8-disable",
      activation = Activation(
        jdk = "[1.8,)"
      ),
      build = BuildBase(
        plugins = Seq(
          Plugin(
            "org.apache.maven.plugins" % "maven-javadoc-plugin",
            configuration = Config(
              additionalparam = "-Xdoclint:all -Xdoclint:-missing"
            )
          )
        )
      )
    ),
    Profile(
      id = "hadoop-1"
    ),
    Profile(
      id = "hadoop-2.2"
    ),
    Profile(
      id = "hadoop-2.3"
    ),
    Profile(
      id = "hadoop-2.4"
    ),
    Profile(
      id = "hadoop-2.6"
    ),
    Profile(
      id = "yarn",
      modules = Seq(
        "yarn",
        "network/yarn"
      )
    ),
    Profile(
      id = "mapr3"
    ),
    Profile(
      id = "mapr4",
      dependencies = Seq(
        Dependency(
          "org.apache.curator" % "curator-recipes" % "${curator.version}",
          exclusions = Seq(
            "org.apache.zookeeper" % "zookeeper"
          )
        ),
        "org.apache.zookeeper" % "zookeeper" % "3.4.5-mapr-1406"
      )
    ),
    Profile(
      id = "hive-thriftserver",
      modules = Seq(
        "sql/hive-thriftserver"
      )
    ),
    Profile(
      id = "scala-2.10",
      activation = Activation(
        property = ActivationProperty(
          name = "!scala-2.11"
        )
      ),
      dependencyManagement = DependencyManagement(
        dependencies = Seq(
          "${jline.groupid}" % "jline" % "${jline.version}"
        )
      )
    ),
    Profile(
      id = "test-java-home",
      activation = Activation(
        property = ActivationProperty(
          name = "env.JAVA_HOME"
        )
      )
    ),
    Profile(
      id = "scala-2.11",
      activation = Activation(
        property = ActivationProperty(
          name = "scala-2.11"
        )
      )
    ),
    Profile(
      id = "release"
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
    ),
    Profile(
      id = "sparkr"
    )
  ),
  modelVersion = "4.0.0"
)
