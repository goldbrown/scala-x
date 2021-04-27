package chris.akka.simple

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import chris.akka.simple.MyServer.Query

/**
 * @description:
 * @author: chris
 * @date: 2021/4/12
 */
object MyClient {
  //final case class Response(name: String, server :ActorRef[Query])
  final case class Command(command: String)
  def apply(): Behavior[Command] = Behaviors.setup { context =>
    //#create-actors
    val myServer = context.spawn(MyServer(), "myServer")
    //#create-actors

    Behaviors.receiveMessage { message =>
      myServer ! Query(1, context.self)
      Behaviors.same
    }
  }

}
