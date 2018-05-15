object AppDemoScala {
  def main(args: Array[String]): Unit = {
    println("Hello world from scala")
    JavaDemo.main(null)
    GroovyDemo.main(null)

    val a="exit"
    val b="exit"
    val c= Array[Object]("exit")
    println(c)
    if (a==b){
      println("equal")
    }
    if(a==c(0)){
      println("equal2")
    }
    if(a.equals(c(0))){
      println("equal3")
    }
  }
}