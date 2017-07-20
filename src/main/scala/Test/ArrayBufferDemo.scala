package Test

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wanglei on 2017/7/13.
  */
object ArrayBufferDemo {
  def main(args: Array[String]): Unit = {
    //定长数组Array
    val nums = new Array[Int](10)
//    val array1 = Array(1 to 10: _*)
    val strarray = Array("aa", "bb", "cc", "dd")

    println(nums.mkString(","))

//    println(array1.mkString(","))
    println(strarray.mkString(","))

    println("================================")
    //变长数组
    var numArrayBuffer = new ArrayBuffer[Int]();

    //.+=()  是一个方法  ，+= 是一个运算符  效果是等价的
    numArrayBuffer.+=(1)
    numArrayBuffer.+=(2)
    numArrayBuffer.+=(3)
    numArrayBuffer += 4
    numArrayBuffer += 5
    numArrayBuffer += 6
    numArrayBuffer += 7

    println(numArrayBuffer.mkString(","))
    println("================================")

    var stringArrayBuffer = new ArrayBuffer[Array[Int]]()
    val array1 = Array(1, 2, 3, 4, 5)
//    stringArrayBuffer.+=(array1)


    println("select reg.reg_time,reg.g to_date(o.order_time)<date_add(reg.reg_time," + "2017-07-12" + ") " +
      "group by reg.reg_time,reg.game_ame_id,reg.expand_channel,sum(if(o.order_status = 4,o.ori_price,-o.ori_price)) amount \" +\n        \"from filter_regi reg join ods_order o on reg.game_account = o.game_account and o.order_status in(4,8) \" +\n        \"where to_date(o.order_time)>=reg.reg_time andid,reg.expand_channel"
    )

    //    /n是换行的意思 ，但是写sql  没必要换行
    println("select account.reg_time,account.game_id,account.expand_channel,account.account_count," +
      "if(ltv2day.amount is null,0,ltv2day.amount) ltv2_amount,if(ltv3day.amount is null,0,ltv3day.amount) ltv3_amount,\n" +
      "if(ltv4day.amount is null,0,ltv4day.amount) ltv4_amount,if(ltv5day.amount is null,0,ltv5day.amount) ltv5_amount\n" +
      ",if(ltv6day.amount is null,0,ltv6day.amount) ltv6_amount,if(ltv7day.amount is null,0,ltv7day.amount) ltv7_amount," +
      "if(ltv15day.amount is null,0,ltv15day.amount) ltv15_amount,if(ltv30day.amount is null,0,ltv30day.amount) ltv30_amount," +
      "if(ltv60day.amount is null,0,ltv60day.amount) ltv60_amount " +
      "from account_count account " +
      "left join ltv2_day ltv2day on ltv2day.reg_time=account.reg_time and ltv2day.game_id=account.game_id and ltv2day.expand_channel=account.expand_channel " +
      "left join ltv3_day ltv3day on account.reg_time=ltv3day.reg_time and account.game_id=ltv3day.game_id and account.expand_channel=ltv3day.expand_channel " +
      "left join ltv4_day ltv4day on ltv4day.reg_time=account.reg_time and ltv4day.game_id=account.game_id and ltv4day.expand_channel=account.expand_channel " +
      "left join ltv5_day ltv5day on account.reg_time=ltv5day.reg_time and account.game_id=ltv5day.game_id and account.expand_channel=ltv5day.expand_channel " +
      "left join ltv6_day ltv6day on ltv6day.reg_time=account.reg_time and ltv6day.game_id=account.game_id and ltv6day.expand_channel=account.expand_channel " +
      "left join ltv7_day ltv7day on account.reg_time=ltv7day.reg_time and account.game_id=ltv7day.game_id and account.expand_channel=ltv7day.expand_channel " +
      "left join ltv15_day ltv15day on ltv15day.reg_time=account.reg_time and ltv15day.game_id=account.game_id and ltv15day.expand_channel=account.expand_channel " +
      "left join ltv30_day ltv30day on account.reg_time=ltv30day.reg_time and account.game_id=ltv30day.game_id and account.expand_channel=ltv30day.expand_channel " +
      "left join ltv60_day ltv60day on ltv60day.reg_time=account.reg_time and ltv60day.game_id=account.game_id and ltv60day.expand_channel=account.expand_channel")

  }


}
