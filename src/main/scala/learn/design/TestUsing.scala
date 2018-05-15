package learn.design

import java.io.FileInputStream

import resource._

/**
  * Created by xiaoyue26 on 17/7/22.
  */

object TestUsing {
  def test1(): Unit = {
    for {
      input <- managed(new java.io.FileInputStream("test.out"))
      output <- managed(new java.io.FileOutputStream("test2.out"))
    } {
      val buffer = new Array[Byte](512)

      def read(): Unit = input.read(buffer) match {
        case -1 => ()
        case n =>
          output.write(buffer, 0, n)
          read()
      }

      read()
    }
  }

  def test2(): Unit = {
    type Closeable = {def close(): Unit}

    final class CloseAfter[A <: Product](val x: A) {
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
    }
    // 传入的对象必须是 Product的子类, 然后自动装配上closeAfter方法
    implicit def any2CloseAfter[A <: Product](x: A): CloseAfter[A] = new CloseAfter(x)

    import java.io._
    // 把tuple中可以关闭的资源一一关闭
    val res_tuple = (new BufferedReader(new FileReader("test.out")),
      new PrintWriter("test2.out"),
      new PrintWriter("test3.out"))

    println(res_tuple.getClass)

    def doJob(in: BufferedReader, out: PrintWriter, other: PrintWriter): Unit = {
      println(in.readLine)
      out.println("output from test2")
      other.println("hello world! from test2")
    }

    res_tuple closeAfter { case (in, out, other) =>
      doJob(in, out, other)
    }
  }

  def main(args: Array[String]): Unit = {
    test2()

  }
}
