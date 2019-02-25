import Dependencies._
import scalapb.compiler.Version.protobufVersion

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "hello-grpc-scala",
    libraryDependencies += scalaTest % Test
  )

// @see https://xuwei-k.github.io/scala-protobuf-docs/setup.html
PB.targets in Compile := Seq(
  protoc_lint.ProtocLint() -> (sourceManaged in Compile).value,
  PB.gens.java(protobufVersion) -> ((sourceManaged in Compile).value / "protobuf-java"),
  scalapb.gen(javaConversions=true) -> ((sourceManaged in Compile).value / "protobuf-scala")
)
