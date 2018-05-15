package akka

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

/**
  * Created by xiaoyue26 on 17/12/22.
  */
class HelloActor extends Actor {
  override def receive: Receive = {
    case "hello" => println("您好!")
    case _ => println("黑暗森林")
  }
}

object HelloActor extends App {
  val system = ActorSystem("hello_system")
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  helloActor ! "hello"
  helloActor ! "神秘语言"
  system.terminate()
}
