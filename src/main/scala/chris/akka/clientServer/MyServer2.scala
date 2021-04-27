package chris.akka.clientServer

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}
import chris.akka.clientServer.MyClient2.Command
import chris.akka.clientServer.MyServer2.ServerQuery

/**
 * @description:
 * @author: chris
 * @date: 2021/4/12
 */

object MyServer2 {
  case class ServerQuery(id: Int, from: ActorRef[Command])

  def apply(): Behavior[ServerQuery] =
    Behaviors.setup(context => new MyServer2(context))
}

class MyServer2(context: ActorContext[ServerQuery]) extends AbstractBehavior[ServerQuery](context) {
  override def onMessage(msg: ServerQuery): Behavior[ServerQuery] =
    msg match {
      case ServerQuery(id, from) =>
        context.log.info("Receive query command from {}", from.path)
        from ! MyClient2.Response(id, "I am akka", context.self)
        this
    }
}
