package learn.phase1

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar

/**
  * Created by xiaoyue26 on 17/8/18.
  */
object DtUtils {
  val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")

  def dtAdd(dtStr: String, interval: Int): String = {

    val dtDate = dateFormat.parse(dtStr)
    val cal: Calendar = Calendar.getInstance()
    cal.setTime(dtDate)
    cal.add(Calendar.DATE, +interval)
    dateFormat.format(cal.getTime)
  }

  def time2dt(timestamp: String): String = {
    val unset = "unset"
    if (null == timestamp || timestamp.length < 10) {
      return unset
    }
    try {
      var input: String = timestamp + "000"
      input = input.substring(0, 13)
      dateFormat.format(new Timestamp(input.toLong))
    } catch {
      case ex: Throwable => println(ex.getCause)
        println(ex.getMessage)
        println(ex.getLocalizedMessage)

        unset
    }

  }

  def test(): Unit = {
    var start_dt = "2017-08-12"
    val end_dt = "2017-08-01"
    for (i <- 1 until 3) {
      println(i)
    }
    //println(dtAdd(start_dt, -1))
    while (start_dt >= end_dt) {
      println(start_dt)
      start_dt = dtAdd(start_dt, -1)
    }
    var line = s"look at here : cur_dt"
    line = line.replace("cur_dt", start_dt)
    println(line)
  }

  def test2(): Unit = {
    println(time2dt("1501643300"))
    println(time2dt("15016433007508756"))
    println(time2dt("15016433007508756s"))
    println(time2dt("f15016433007508756s"))
  }

  def main(args: Array[String]): Unit = {
    test2()

  }
}
