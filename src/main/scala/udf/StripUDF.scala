package udf

import org.apache.commons.lang.StringUtils

/**
  * Created by xiaoyue26 on 17/11/3.
  */
class StripUDF {
  def strip(input: String, chars: String): String = {
    StringUtils.strip(input, chars)
  }

  def strip(input: String, chars: String, mode: String): String = {
    mode match {
      case "l" => StringUtils.stripStart(input, chars)
      case "r" => StringUtils.stripEnd(input, chars)
      case _ => StringUtils.strip(input, chars)
    }
  }
}

object StripUDF {


  def main(args: Array[String]): Unit = {
    val obj = new StripUDF
    println(obj.strip("[input]","[]"))
    println(obj.strip("[input]","[]","l"))

  }

}
