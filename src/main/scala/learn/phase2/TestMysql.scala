package learn.phase2

import java.sql.{Connection, DriverManager, ResultSet}

/**
  * Created by xiaoyue26 on 17/7/21.
  */
object TestMysql {
  val driver = "com.mysql.jdbc.Driver"

  val getUrl: String = {
    val host = "localhost"
    val db = "pipe_ape"
    val user = "root"
    val password = "mysql"
    "jdbc:mysql://%s:3306/%s?user=%s&password=%s".format(host, db, user, password)
  }

  def createConnection(): Unit = {
    Class.forName("com.mysql.jdbc.Driver").newInstance()
  }

  def read(): Unit = {
    val url = getUrl
    var conn: Connection = null
    try {
      Class.forName(driver)
      conn = DriverManager.getConnection(url)
      val statement = conn.createStatement()
      val resultSet: ResultSet = statement.executeQuery("SELECT * FROM test")
      while (resultSet.next()) {
        var res_list: List[String] = List()
        res_list = res_list :+ resultSet.getString("name")
        res_list = res_list :+ resultSet.getString("col1")
        res_list = res_list :+ resultSet.getString("col2")
        println(res_list.mkString(","))
      }
    } catch {
      case e: Throwable => e.printStackTrace()
    }
    finally {
      conn.close()
    }
  }

  def write(): Unit = {
    val url = getUrl
    var conn: Connection = null
    try {
      Class.forName(driver)
      conn = DriverManager.getConnection(url)
      val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)
      //val statement = conn.createStatement()
      val prep = conn.prepareStatement("replace into test(name,col1)values(?,?)")
      prep.setString(1, "insert_name")
      prep.setInt(2, 123)
      prep.executeUpdate()
    } catch {
      case e: Throwable => e.printStackTrace()
    }
    finally {
      conn.close()
    }


  }

  def main(args: Array[String]): Unit = {
    read()
  }


}
