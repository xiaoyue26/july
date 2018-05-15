package akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}


/**
  * Created by xiaoyue26 on 17/12/22.
  */
// 近似于枚举类型:
case object PingMessage

case object PongMessage

case object StartMessage

case object StopMessage

class Ping(pong: ActorRef) extends Actor {
  var count = 0

  def incrementAndPrint() {
    count += 1; println("ping")
  }

  def receive = {
    case StartMessage =>
      incrementAndPrint()
      pong ! PingMessage
    case PongMessage =>
      if (count > 9) {
        sender ! StopMessage
        println("ping stopped")
        context.stop(self)
      } else {
        incrementAndPrint()
        sender ! PingMessage
      }
  }
}

class Pong extends Actor {
  def receive = {
    case PingMessage =>
      println("  pong")
      sender ! PongMessage
    case StopMessage =>
      println("pong stopped")
      context.stop(self)
      context.system.terminate()
  }
}

object PingPongTest {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("PingPongSystem")
    val pong = system.actorOf(Props[Pong], name = "pong")
    val ping = system.actorOf(Props(new Ping(pong)), name = "ping")
    // start them going
    ping ! StartMessage
  }
}
