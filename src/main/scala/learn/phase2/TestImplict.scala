package learn.phase2

/**
  * Created by xiaoyue26 on 17/7/26.
  */
object TestImplict {
  // 用法1. 隐式参数
  def test1(): Unit = {
    // 两个参数列表,其中隐式参数的列表放在最后.(隐式参数的列表最多有一个)
    def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate

    // 默认参数值,上下文中只能出现一个. 出现两个会报错,不出现也报错.
    implicit val currentTaxRate = 0.08F
    val tax = calcTax(50000F) // 4000.0
    println(tax)
  }

  // 用法2. 隐式地转换类型
  def test2(): Unit = {
    // 在当前上下文中定义隐式转换的函数. 函数名可以使任何名字.
    implicit def kkk(d: Double): Int = d.toInt

    val i: Int = 3.5 // 被隐式转换的赋值,以下划线进行提示.
    println(i) // 输出3
  }

  def main(args: Array[String]): Unit = {
    test2()
  }
}


// 用法3. 隐式调用函数.
// 其实和用法2类似,用法2是自动把基本类型转换,这里是自动把对象类型转换.
class SwingType {
  def wantLearned(sw: String) {
    println("兔子已经学会了" + sw)
  }
}

object swimming {
  // 定义一个可以被自动应用的函数
  implicit def learningType(s: AminalType): SwingType = new SwingType
}
// 超级简洁的类定义:
class AminalType

object AminalType extends App {
  import swimming._  // 引入swimming中的方法到当前上下文
  val rabbit = new AminalType
  // 发生了隐式调用的函数被下划线. AminalType中没有这个方法, 试图把AminalType变成具有这个方法的对象.
  // 找到了learningType=> rabbit变成了SwingType对象,具有了wantLearned方法.
  rabbit.wantLearned("breaststroke") //蛙泳
}
