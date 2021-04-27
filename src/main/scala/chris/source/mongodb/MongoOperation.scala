package chris.source.mongodb

import org.mongodb.scala._
import org.mongodb.scala.result.InsertOneResult

import scala.concurrent.duration.{Duration, SECONDS}
import scala.concurrent.{Await, ExecutionContext}
/**
 * @description: for document, see https://mongodb.github.io/mongo-java-driver/4.2/driver-scala/getting-started/quick-start/
 * @author: chris
 * @date: 2021/4/8
 */
object MongoOperation {

  val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017/")
  val database: MongoDatabase = mongoClient.getDatabase("chris")

  def main(args: Array[String]): Unit = {
//    createCollection()
//    writeMongo()
    readMongo
  }

  def createCollection() = {
    val mongoClient: MongoClient = MongoClient()
    val database: MongoDatabase = mongoClient.getDatabase("chris")
    val future = database.createCollection("person").toFuture() // async
    Await.result(future, Duration(5, SECONDS)) // wait for result
    println("done")
  }


  def writeMongo() = {
    val collection: MongoCollection[Document] =database.getCollection("person")
    val doc: Document = Document("_id" -> 2, "name" -> "MongoDB","age" -> 13, "profile" -> Document("hobby" -> "eat"))
    val observable: Observable[InsertOneResult] = collection.insertOne(doc)
    val f = observable.toFuture()
    Await.result(f, Duration(5, SECONDS)) // wait for result
    println("insert done")
  }

  def readMongo() = {
    val collection: MongoCollection[Document] =database.getCollection("person")
    val f = collection.find().first().toFuture()
    Await.result(f, Duration(5, SECONDS)) // wait for result
    f.map(doc => println(doc))(ExecutionContext.global)
    Thread.sleep(1000)
  }

}
