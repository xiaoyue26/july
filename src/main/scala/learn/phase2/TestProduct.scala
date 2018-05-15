package learn.phase2

/**
  * Created by xiaoyue26 on 17/7/22.
  */
object TestProduct {
  // Product 是所有 case class 编译后会依赖的 trait (with Product)
  /**
    * case class 是用于封装数据的实体
    * product trait 表示一种成员变量的笛卡尔积
    * product包括 product1 到 product22,换句话说就是1个成员到22个成员的笛卡尔积.
    * 这里的笛卡尔积理解为这n个成员的值可以变化,因此这个product的取值也可以不断变化,可能性就是笛卡尔积了.
    *
    * ::[B] 是 product 的一个子类
    * */
  def test1(): Unit = {
    val a = List(1, 2, 3)
    val b = List(4, 5, 6)
    val c = List(a, b)
    val d = (a, b)
    val e = Tuple3(a, a, a) // Tuple3 依赖于 Product3
    val f = List(a,a,a)     // List 依赖于 Product , 从结果来看具体数量是2 (productArity). 语义上理解,List的结构包括head,tail
    println("c.productIterator:")
    c.productIterator foreach println // List(List(4, 5, 6))
    println("d.productIterator:")
    d.productIterator foreach println
    println("e.productIterator:")
    e.productIterator foreach println // 三个 product
    println("f.productIterator:")
    f.productIterator foreach println // 两个 product
  }

  def main(args: Array[String]): Unit = {
    test1()
  }
}
