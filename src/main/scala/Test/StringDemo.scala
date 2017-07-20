package Test

/**
 * Created by JSJSB-0071 on 2017/7/20.
 */
object StringDemo {
  def main(args: Array[String]) {
    val str = "abcdefghijklmn"
    val index = str.indexOf("e")
    println(index)
    val strsub = str.substring(3,10) //街区字符串是包含头不包含尾
    println(strsub)

    val currentday = "2017-06-01"
    val hivesql="select  \nregi.game_account,\nregi.owner_id as uid,\nif(mainid is null,0,mainid) as game_id,\nif(maingname is null,'',maingname) as game_name,\ncase when reg_resource=1 then 1 else 2 end as user_type,\nif(relate_time is null,'0000-00-00',relate_time) regi_time,\nif(last_login_time is null,'0000-00-00',last_login_time) last_login_time,\ncase when regi.bind_uid_time is null then 0 else 1 end as is_recharge,\nif(pu.username is null,'',pu.username) user_account,\nif(reg_os_type is null,'UNKNOW',reg_os_type) platform\nfrom ods_regi regi join promo_user pu on pu.member_id=regi.owner_id \nleft join (select game_account,max(login_time) as last_login_time from ods_login group by game_account) lg on regi.game_account=lg.game_account\njoin gameinfo gf on gf.id=regi.game_id\n where to_date(regi.relate_time)='currentday' and regi.owner_id!=0 and regi.owner_id is not null and regi.game_account is not null "
    val mysqlsql=" insert into bi_centurioncard_accountinfo(game_account,uid,game_id,game_name,user_type,regi_time,last_login_time,is_recharge,user_account,platform)" +
      " values(?,?,?,?,?,?,?,?,?,?)" +
      " on duplicate key update game_name=?,user_type=?,regi_time=?,last_login_time=?,is_recharge=?,user_account=?,platform=?"
    val execSql=hivesql.replace("currentday",currentday)
    val sql2Mysql = mysqlsql.replace("|"," ").toLowerCase
//    println(execSql)
    println(sql2Mysql)

    val startValuesIndex = sql2Mysql.indexOf("(?")+1
    println(startValuesIndex)
    val endValuesIndex = sql2Mysql.indexOf("?)")+1
    println(endValuesIndex)
    val sql2MysqlSub = sql2Mysql.substring(startValuesIndex,endValuesIndex)
    println(sql2MysqlSub)

  }

}
