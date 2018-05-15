package learn.design

/**
  * Created by xiaoyue26 on 17/7/31.
  */

final class CloseAfter[A <: Product](val x: A) {
  type Closeable = {def close(): Unit}
  // 传入的参数是一个A=>B的映射,A是一个多元组,B是具体执行的语句.
  def closeAfter[B](block: A => B): B = {
    try {
      block(x) // 执行映射block
    } finally {
      for (i <- 0 until x.productArity) {
        x.productElement(i) match {
          case c: Closeable => println("closing " + c)
            c.close()
          case _ =>
        }
      }
    }
  }
  // client:
  implicit def any2CloseAfter[A <: Product](x: A): CloseAfter[A] = new CloseAfter(x)
}
