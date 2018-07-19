
scalaVersion := "2.11.8"

val test = project.in(file("."))
  .enablePlugins(GatlingPlugin)
  .settings(libraryDependencies ++= Seq("io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.2" % "test",
										"io.gatling"            % "gatling-test-framework"    % "2.2.2" % "test")
			)
