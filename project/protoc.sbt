// @see https://github.com/thesamet/sbt-protoc
addSbtPlugin("com.thesamet" % "sbt-protoc" % "0.99.19")
libraryDependencies += "com.thesamet.scalapb" %% "compilerplugin" % "0.8.3"

// @see https://github.com/scalapb-json/protoc-lint
addSbtPlugin("com.thesamet" % "sbt-protoc" % "0.99.19")
libraryDependencies += "io.github.scalapb-json" %% "protoc-lint-shaded" % "0.2.1"
