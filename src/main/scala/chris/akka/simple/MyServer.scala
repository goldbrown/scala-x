package chris.akka.simple

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors
import chris.akka.simple.MyClient.Command

/**
 * @description:
 * @author: chris
 * @date: 2021/4/12
 */
object MyServer {
  final case class Query(id: Int, client :ActorRef[Command])

  def apply(): Behavior[Query] = Behaviors.receive {
    (context, message) => {
      println(s"receive message from ${message.client}")
      println(s"handle query")
      Thread.sleep(1000)
      Behaviors.same
    }
  }
}
