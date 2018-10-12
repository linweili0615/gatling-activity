import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._


class RegisterTest extends Simulation{
    val regConf = http.baseURL("http://10.100.14.5:9002/")
//    val params = Array(
//      Map("extDTO" -> Map("callBackParams" -> "")),
//      Map("password" -> "123456a"),
//      Map("registerFrom" -> "TUANDAI-PC"),
//      Map("telNo" -> "16696356984"),
//      Map("isExecuteBusiness" -> true)
//    )
//    val regscn = scenario("reg-scenario")
//      .exec(
//        http("注册")
//          .post("/user/registerByPhoneV3")
//          .header("Content-Type","application/json;charset=UTF-8 ")
//          .body(StringBody("{\n \"extDTO\": {\n    \"callBackParams\": \"\"\n  },\n  \"password\": \"123456a\",\n  \"registerFrom\": \"TUANDAI-PC\",\n  \"telNo\": \"19936986547\",\n  \"isExecuteBusiness\":true\n}"))
//          .check(status.is(200))
//      )
    val regscn1 = scenario("reg-scenario1")
    .during(100){
      exec(
        http("注册1")
        .post("/user/registerByPhoneV3")
        .header("Content-Type","application/json;charset=UTF-8 ")
        .body(StringBody("{\n \"extDTO\": {\n    \"callBackParams\": \"\"\n  },\n  \"password\": \"123456a\",\n  \"registerFrom\": \"TUANDAI-PC\",\n  \"telNo\": \"19936986547\",\n  \"isExecuteBusiness\":true\n}"))
        .check(status.is(200))
      )
    }


    setUp(regscn1.inject(atOnceUsers(10)).protocols(regConf))
}
