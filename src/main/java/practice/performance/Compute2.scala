package practice.performance

import java.util
import java.util.Random

import io.netty.buffer.ByteBufHolder

import scala.collection.mutable.ListBuffer


/**
  * @author xiaoyue26
  *         测试用map和数组的性能差异
  */
object Compute2 {
  private val random = new Random
  private val mapCombineMap = new util.HashMap[(String, Int), Int](64)
  private val opTypes = Array[String]("0X80066F4", " 0X80066F8", " 0X80066F9", " 0X8007625", " 0X8007626", " 0X80081C3", " 0X80081C4", " 0X80081DB", " 0X80081DC", " 0X80091DC", " 0X8007408", " 0X8007409")


  private val inputData = ListBuffer[(String, Int, Int)]()

  def prepareData(): Unit = {
    for (i <- 1 to 10000) {
      val opType = opTypes(random.nextInt(opTypes.length))
      val pv = random.nextInt()
      val flag = random.nextInt(4)
      inputData.append((opType, pv, flag))
    }
  }

  def testMap(): Unit = {
    for (line <- inputData) {
      val opType = line._1
      val pv = line._2
      val flag = line._3
      val key = (opType, flag)
      val old = mapCombineMap.getOrDefault(key, 0)
      mapCombineMap.put(key, old + pv)
    }
  }

  def testArray(): Unit = {


  }

  def main(args: Array[String]): Unit = {
    var begin = 0L
    var end = 0L

    prepareData()
    begin = System.currentTimeMillis
    testMap()
    end = System.currentTimeMillis
    System.out.println("testMap duration:" + (end - begin) + "ms") // ms


    begin = System.currentTimeMillis
    testArray()
    end = System.currentTimeMillis
    System.out.println("testArray duration:" + (end - begin) + "ms")


    Compute1.taskQueue.add(new util.HashMap[Array[AnyRef],Integer]())
  }
}
