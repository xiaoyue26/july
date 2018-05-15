package udf


import org.apache.commons.lang.StringUtils
import com.alibaba.fastjson.JSON


/**
  * Created by xiaoyue26 on 17/10/30.
  */
class JsonArray {

  def evaluate(input: String): Seq[scala.collection.immutable.Map[String, String]] = {
    if (StringUtils.isBlank(input)) return null
    try {
      val oldRes = JSON.parse(input).asInstanceOf[java.util.List[java.util.Map[Object, Object]]]
      import scala.collection.JavaConverters._

      val dd = oldRes.asScala.toList.map({
        d => d.asScala.toMap.map { case (k, v) => (k.toString, v.toString) }
      })
      return dd
    } catch {
      case e: Exception =>
        e.printStackTrace()
        null
    }
  }

  def evaluate2(input: String): java.util.List[java.util.Map[String, String]] = {
    if (StringUtils.isBlank(input)) return null
    try {
      return JSON.parse(input).asInstanceOf[java.util.List[java.util.Map[String, String]]]
    } catch {
      case e: Exception =>
        e.printStackTrace()
        null
    }
  }


}

object JsonArray {
  def main(args: Array[String]): Unit = {
    val obj: JsonArray = new JsonArray
    val input: String = "[{\"a\":1},{\"b\":\"2\"}]"
    System.out.println(obj.evaluate(input))
    System.out.println(obj.evaluate2(input))
  }
}
