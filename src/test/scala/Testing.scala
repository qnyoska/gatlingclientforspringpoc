package test.scala

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class Testing extends Simulation {

  val httpConf = http
    .baseURL("http://cloud1:8080")

  val osszes = scenario("Osszes")
    .exec(http("getfluxrandom")
      .get("/getfluxrandom?id=1200000")
      .check(bodyString.saveAs("fluxrandom")))
      .pause(3)
//    .exec(http("fluxmass")
//      .get("/getfluxmass")
//      .check(bodyString.saveAs("fluxmass")))
//      .pause(3)
//    .exec(session => {
  //    println(session("fluxrandom").as[String])
//      println(session("fluxmass").as[String])
//      session
    //})
    .pause(3)

  //  setUp(
  //    authentication.inject(atOnceUsers(1)),
  //    transactionHistory.inject(atOnceUsers(1))).protocols(httpConf)

  setUp(
    osszes.inject(rampUsers(1000) over (10 seconds))).protocols(httpConf)
}
