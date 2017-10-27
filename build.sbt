name := """play-react-redux-typescript-webpack"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  jdbc,
  ehcache,
  guice,
  ws,
  specs2 % Test
)

PlayKeys.playRunHooks <+= baseDirectory.map(Webpack.apply)

routesGenerator := InjectedRoutesGenerator

watchSources ~= { (ws: Seq[File]) =>
  ws filterNot { path =>
    path.getName.endsWith(".ts") || path.getName.endsWith(".tsx") || path.getName == ("build")
  }
}

pipelineStages := Seq(digest, gzip)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"


