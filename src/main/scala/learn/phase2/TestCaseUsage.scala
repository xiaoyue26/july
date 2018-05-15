package learn.phase2

/**
  * Created by xiaoyue26 on 17/7/29.
  */
object TestCaseUsage {
  def needfunc[F](f: F) = f

  // 探究 { case x => 2 * x } 的真正类型
  def main(args: Array[String]): Unit = {
    // 1.
    println(needfunc[PartialFunction[Int, Int]]({ case x => 2 * x }).getClass) // 匿名函数
    println(needfunc[PartialFunction[Int, Int]]({ case x => 2 * x }).getClass.getSuperclass) // 父类是偏应用

    // 2.
    println(needfunc[Int => Int]({ case x => 2 * x }).getClass)
    println(needfunc[Int => Int]({ case x => 2 * x }).getClass.getSuperclass)
  }
}
