package hbase.utils

import java.util
import java.util.NavigableMap

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.hadoop.hbase.client._
import org.apache.hadoop.hbase.util.Bytes

/**
  * Created by xiaoyue26 on 17/10/17.
  */
class HbaseUtilsOld2 {
  /**
    * 可以用scala写java,加上typedef(type),缩短很长的类型名
    */
  val config: Configuration = HBaseConfiguration.create
  config.addResource("hbase-site.xml")
  type nmap = util.NavigableMap[Array[Byte], util.NavigableMap[Array[Byte], util.NavigableMap[Long, Array[Byte]]]]


}

object HbaseUtilsOld2 {
  def main(args: Array[String]): Unit = {
    test1()
  }

  def test1(): Unit = {
    val CF = "NEWCF".getBytes
    val ATTR = "attr".getBytes
    val TABLE_NAME: String = "MYTABLE"


  }
}
