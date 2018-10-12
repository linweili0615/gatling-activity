import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

/**
  * 类必须继承 Simulation
  * 声明Scenario，指定我们的请求动作
  * exec()里的参数就是我们的执行动作，http(“本次请求的名称”).get(“本次http get请求的地址”)
  * 设置并发数并组装
  */



class Test extends Simulation{

  //设置请求的根路径
  val httpConf = http.baseURL("https://www.baidu.com")
  /*
    运行100秒 during 默认单位秒,如果要用微秒 during(100 millisecond)
   */
  val scn = scenario("Test").
    during(10){
      //baidu_home  本次请求的名称
    exec(http("baidu_home").get("/"))
  }
  //设置线程数
  /**
    * atOnceUsers：立马启动的用户数，可以理解为并发数
    */
  setUp(scn.inject(atOnceUsers(10)).protocols(httpConf))




}
