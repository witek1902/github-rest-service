import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {

  val users: Int = 1
  val baseUrl: String = "http://localhost:8080"

  val httpConf = http
    .baseURL(baseUrl)
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("BasicSimulation")
    .exec(getRepositoryList)
    .pause(5)
    .exec(getSelectedRepository)

  def getRepositoryList =
    http("Get Allegro Repository List")
        .get("/repositories/allegro")

  def getSelectedRepository =
    http("Get Akubra Allegro Repository")
      .get("/repositories/allegro/akubra")

  setUp(
    scn.inject(atOnceUsers(users))
  ).protocols(httpConf)
}