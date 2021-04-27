package chris.akka.clientServer

import akka.actor.typed.ActorSystem
import chris.akka.clientServer.MyClient2.Query

/**
 * @description: A simple client-server pattern
 * @author: chris
 * @date: 2021/4/10
 */


object User2 extends App {
  val myClient2 = ActorSystem.create(MyClient2(), "myClient2")
  val start = System.currentTimeMillis()
  myClient2 ! Query(1)
}
