package udf

import java.io.IOException
import java.util
import java.util.{ArrayList, List}

import entity.{AnswerResult, AnswerResults}
import org.apache.commons.codec.DecoderException
import org.apache.commons.codec.binary.Hex
import org.apache.commons.lang.StringUtils
import org.codehaus.jackson.map.ObjectMapper
import org.apache.thrift.TDeserializer
import org.apache.thrift.TException

/**
  * Created by xiaoyue26 on 17/10/30.
  */
class AnswerResultsUDF {

  def evaluate(binaryText: String): String = {
    var ret: String = null
    val binaryTextArray: Array[String] = binaryText.split(" ")
    val data = new Array[Char](binaryTextArray.length * 2)
    var index: Int = 0
    for (s: String <- binaryTextArray) {
      data(index) = s.charAt(0)
      index += 1
      data(index) = s.charAt(1)
      index += 1
    }
    var bytes: Array[Byte] = null
    val ars = new AnswerResults
    try {
      bytes = Hex.decodeHex(data)
      val tDeserializer = new TDeserializer
      tDeserializer.deserialize(ars, bytes)
    } catch {
      case e: DecoderException =>
        e.printStackTrace()
        println(1)
      case e: TException =>
        e.printStackTrace()
    }

    try {
      val reses = new util.ArrayList[String](ars.getAnswerResultsSize)
      for (i <- 0 until ars.answerResults.size()) {
        val answerResult = ars.getAnswerResults.get(i)
        reses.add(AnswerResultsUDF.objectMapper.writeValueAsString(answerResult))
      }
      return StringUtils.join(reses, ';')
    } catch {
      case e: IOException =>
        e.printStackTrace()
        return null
    }
  }


}

object AnswerResultsUDF {
  val objectMapper: ObjectMapper = new ObjectMapper()

  def main(args: Array[String]): Unit = {
    val obj = new AnswerResultsUDF
    val binaryText = "0f 00 01 0c 00 00 00 05 08 00 01 00 1d 79 63 08 00 02 00 00 00 01 04 00 03 00 00 00 00 00 00 00 00 04 00 04 00 00 00 00 00 00 00 00 00 08 00 01 00 11 bd 67 08 00 02 00 00 00 01 04 00 03 00 00 00 00 00 00 00 00 04 00 04 00 00 00 00 00 00 00 00 00 08 00 01 00 07 bf 7b 08 00 02 00 00 00 01 04 00 03 00 00 00 00 00 00 00 00 04 00 04 00 00 00 00 00 00 00 00 00 08 00 01 00 1d 78 d1 08 00 02 ff ff ff ff 04 00 03 00 00 00 00 00 00 00 00 04 00 04 00 00 00 00 00 00 00 00 00 08 00 01 00 0b 28 0b 08 00 02 ff ff ff ff 04 00 03 00 00 00 00 00 00 00 00 04 00 04 00 00 00 00 00 00 00 00 00 00"
    val res = obj.evaluate(binaryText)
    println(res)

  }

}

