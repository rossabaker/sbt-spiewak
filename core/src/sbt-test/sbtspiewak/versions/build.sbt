ThisBuild / crossScalaVersions := Seq("2.13.3")

ThisBuild / baseVersion := "0.2"

ThisBuild / publishGithubUser := "djspiewak"
ThisBuild / publishFullName := "Daniel Spiewak"

lazy val setup1 = taskKey[Unit]("")
lazy val check1 = taskKey[Unit]("")

lazy val setup2 = taskKey[Unit]("")
lazy val check2 = taskKey[Unit]("")

lazy val setup3 = taskKey[Unit]("")
lazy val check3 = taskKey[Unit]("")

setup1 := {
  import scala.sys.process._

  "git init".!
  "git add .".!
  "git commit -m init".!

  "git tag v0.1.0".!
}

check1 := {
  val v = version.value
  if (v != "0.1.0") {
    sys.error(v)
  }
}

setup2 := {
  import scala.sys.process._

  "git tag -d v0.1.0".!
  "git tag v2.1.7".!
}

check2 := {
  val v = version.value
  if (v != "2.1.7") {
    sys.error(v)
  }
}

setup3 := {
  import scala.sys.process._

  "git tag -d v2.1.7".!
  "git tag v10.123.0-RC2".!
}

check3 := {
  val v = version.value
  if (v != "10.123.0-RC2") {
    sys.error(v)
  }
}
