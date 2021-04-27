package chris.akka.clientServer

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}
import chris.akka.clientServer.MyClient2.{Command, Query}
import chris.akka.clientServer.MyServer2.ServerQuery

/**
 * @description:
 * @author: chris
 * @date: 2021/4/12
 */

object MyClient2 {
  sealed trait Command
  case class Query(id: Int) extends Command
  case class Response(id: Int, content :String, from: ActorRef[ServerQuery]) extends Command

  def apply(): Behavior[Command] =
    Behaviors.setup(context => new MyClient2(context))
}

class MyClient2(context: ActorContext[Command]) extends AbstractBehavior[Command](context) {
  val serverActor = context.spawn(MyServer2(), "server2")
  override def onMessage(msg: Command): Behavior[Command] =
    msg match {
      case Query(id) => {
        context.log.info("get query command from for {}", id)
        serverActor ! ServerQuery(id, context.self)
        this
      }
      case MyClient2.Response(id, content, from) => {
        context.log.info("get response {} from {}", content, from)
        this
      }
    }
}
