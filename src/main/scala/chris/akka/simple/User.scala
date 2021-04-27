package chris.akka.simple

import akka.actor.typed.ActorSystem
import chris.akka.simple.MyClient.Command

/**
 * @description:
 * @author: chris
 * @date: 2021/4/12
 */
object User extends App {
  val myClient = ActorSystem.create(MyClient(), "myClient")
  myClient.!(Command("query"))
  //  myClient.terminate()
}

