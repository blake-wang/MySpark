package cn.wanglei.spark.day07

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2017/6/8.
  */
object GameKPI {
  def main(args: Array[String]): Unit = {

    val queryTime = "2016-02-02 00:00:00"
    val beginTime = TimeUtils(queryTime)
    //+1的意思是从昨天到今天，就是昨天一整天的意思
    val endTime = TimeUtils.getCertainDayTime(+1)

    val conf = new SparkConf().setAppName("GameKPI").setMaster("local[*]")
    val sc = new SparkContext(conf)

    //切分之后的数据
    val splitedLogs = sc.textFile("H:\\BigDataThree\\文档资料\\day33\\游戏日志\\GameLog.txt").map(_.split("\\|"))
    //过滤后并缓存
    val filterLogs = splitedLogs.filter(fields => FilterUtils.filterByTime(fields, beginTime, endTime)).cache()

    //日新增用户数，Daily New Users 缩写 DNU
    val dnu = filterLogs.filter(fields => FilterUtils.filterByType(fields, EventType.REGISTER)).count()
    println("dnu  :  " + dnu)

    //日活跃用户数，Daily Active Users 缩写 DAU
    val dau = filterLogs.filter(fields => FilterUtils.filterByTypes(fields, EventType.REGISTER, EventType.LOGIN))
      .map(_ (3))
      //根据用户名去除重复 ，因为根据上线判断，一个用户名可能每天会登录退出好几次，这样就会出现重复
      .distinct()
      .count
    println("dau  :  " + dau)

    //--------------------------------------------------------------------------------------
    //留存率：某段时间的新增用户数记为A，经过一段时间后，仍然使用的用户占新增用户A的比例即为留存率
    //次日留存率（Day 1 Retention Ratio）
    //日新增用户在+1日登录的用户占新增用户的比例
    val t1 = TimeUtils.getCertainDayTime(-1)
    val lastDayRegUser = splitedLogs
      .filter(fields => FilterUtils.filterByTypeAndTime(fields, EventType.REGISTER, t1, beginTime))
      .map(x => (x(3), 1))

    val todayLoginUser = filterLogs.filter(fields => FilterUtils.filterByType(fields, EventType.LOGIN))
      .map(x => (x(3), 1))
      //有可能同一个用户会多次登录,所以要去掉重复
      .distinct()

    //计算出第二前留存用户数量
    val d1r: Double = lastDayRegUser.join(todayLoginUser).count()
    println("d1r  :  " + d1r)
    //计算出留存率
    val d1rr = d1r / lastDayRegUser.count()
    println("d1rr  :  " + d1rr)
    //-------------------------------------------------------------------------------------


    sc.stop()

  }
}
