package learn.phase1

import java.text.SimpleDateFormat
import java.util.Calendar

/**
  * Created by xiaoyue26 on 17/7/13.
  */
object TestString {
  def main(args: Array[String]): Unit = {
    // 1. StringBuilder
    // test1()

    //  2. printf与format ( 养成用val的习惯(无副作用的函数式编程习惯) )
    // test2()

    // 3. 字符串插值: s , f 和 raw
    // test3() // 也可以写test3

    // 4. 多行字符串
    // test4()

    // 5. dt运算
    test5()

  }


  def test1(): Unit = {
    val buf = new StringBuilder
    buf += 'a'
    buf ++= "bcdef"
    println("buf is : " + buf.toString + "\nlength is : " + buf.length)
  }

  def test2(): Unit = {
    val floatVar: Float = 12.456f
    val intVar: Int = 2000
    val stringVar: String = "string var!"
    val fs1 = printf("浮点型变量为 %f, 整型变量为 %d, 字符串为  %s\n", floatVar, intVar, stringVar)
    // 不能使用String.format, 直接使用 "".format(...)
    val fs2 = "浮点型变量为 %f, 整型变量为 %d, 字符串为  %s\n".format(floatVar, intVar, stringVar)
    println(fs1)
    println(fs2)
  }

  def test3(): Unit = { // 以下特性在 2.10.0 之后生效
    // (1) s 插值
    val name = "James"
    println(s"Hello,$name\n")
    println(s"1+1=${1 + 1}") // 2
    // (2) f 插值  太难看懂了,还是用format函数吧
    val height = 1.9d
    println(f"$name%s is $height%2.2f meters tall") // James is 1.90 meters tall


    // (3) raw 插值 转义变量,不转义控制字符.
    println(raw"a\nb$name")

  }

  def test4(): Unit = {
    val sql1 =
      """SELECT id
        |,productid
        |,userid
        |FROM ape.ods_ape_frog_di
        |WHERE dt='2017-08-20'
      """.stripMargin
    println(sql1)
    val sql2 =
      """SELECT id
        #,productid
        #,userid
        #FROM ape.ods_ape_frog_di
        #WHERE dt='2017-08-20'
      """.stripMargin('#').replaceAll("\n", " ")
    println(sql2)
    val pat =
      """select *
        |from ods_zeb_frog
        |where dt='2017-08-10'
        |limit 10""".stripMargin
  }

  def test5(): Unit = {
    val start_dt = "2017-08-01"
    val end_dt = "2017-08-10"
    val pat =
      """
        |insert overwrite table temp.feng_udf_test partition(dt='${DATE}')
        |SELECT DISTINCT id as message_id
        |      ,userid
        | FROM ape.ods_ape_frog_di
        |WHERE productid in (101,111,121) AND userid is not NULL
        | AND concat_ws('-',year,month,day)='${DATE}'
        | AND url in('/click/OpPush/open')
        |"""
    run_hql(pat, start_dt, end_dt)
  }

  def run_hql(pat: String, start_dt: String, end_dt: String): Unit = {
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")

    def dtAdd(dtStr: String, interval: Int): String = {
      val dtDate = dateFormat.parse(dtStr)
      val cal: Calendar = Calendar.getInstance()
      cal.setTime(dtDate)
      cal.add(Calendar.DATE, +interval)
      return dateFormat.format(cal.getTime)
    }

    def dtDiff(dt1: String, dt2: String): Int = {
      val cal: Calendar = Calendar.getInstance()
      cal.setTime(dateFormat.parse(dt1))
      val time1: Long = cal.getTimeInMillis
      cal.setTime(dateFormat.parse(dt2))
      val time2: Long = cal.getTimeInMillis
      return ((time2 - time1) / (1000 * 3600 * 24)).toInt
    }

    val len: Int = dtDiff(start_dt, end_dt)
    var cur_dt = start_dt
    var step = 1
    if (start_dt > end_dt) {
      step = -1
    }
    for (i <- 0 to len) {
      // until的话,不包括end_dt
      val hql = pat.replace("${DATE}", cur_dt)
      run_hql(hql)
      cur_dt = dtAdd(cur_dt, step)
    }
  }

  def run_hql(hql: String): Unit = {
    println(hql)
    /*import org.apache.spark.sql.hive.HiveContext
    val hiveCtx = new org.apache.spark.sql.hive.HiveContext(sc)
    hiveCtx.sql(line)*/
  }
}
