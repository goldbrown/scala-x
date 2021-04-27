package chris.collection

import java.util

import scala.jdk.CollectionConverters

/**
 * @description:
 * @author: chris
 * @date: 2021/4/16
 */
object CollectionMain {

  def scalaCollection2JavaCollection() = {
    // List
    println("list:")
    val scalaList = List(Person("Chris", 12))
    val javaList = CollectionConverters.SeqHasAsJava(scalaList).asJava
    println(scalaList.getClass)
    println(javaList.getClass)

    // Array
    println("array:")
    val scalaArray = Array(Person("Chris", 12))
    val javaArray = CollectionConverters.SeqHasAsJava(scalaArray).asJava
    println(scalaArray.getClass)
    println(javaArray.getClass)

    // Seq
    println("seq:")
    val scalaSeq = Seq(Person("Chris", 12))
    val javaSeq = CollectionConverters.SeqHasAsJava(scalaSeq).asJava
    println(scalaSeq.getClass)
    println(javaSeq.getClass)


    // Set
    println("set:")
    val scalaSet = Set(Person("Chris", 12))
    val javaSet = CollectionConverters.SetHasAsJava(scalaSet).asJava
    println(scalaSet.getClass)
    println(javaSet.getClass)


    // Map
    println("map:")
    val scalaMap = Map("Chris" -> Person("Chris", 12))
    val javaMap = CollectionConverters.MapHasAsJava(scalaMap).asJava
    println(scalaMap.getClass)
    println(javaMap.getClass)
  }

  def javaCollection2ScalaCollection(): Unit = {
    // List
    println("list:")
    val javaList = new util.ArrayList[Person]()
    javaList.add(Person("Chris", 12))
    val scalaList = CollectionConverters.ListHasAsScala(javaList).asScala
    println(javaList.getClass)
    println(scalaList.getClass)

    // Set
    println("set:")
    val javaSet = new util.HashSet[Person]()
    val scalaSet = CollectionConverters.SetHasAsScala(javaSet).asScala
    println(javaSet.getClass)
    println(scalaSet.getClass)

    // Map
    println("map:")
    val javaMap = new util.HashMap[String, Person]()
    val scalaMap = CollectionConverters.MapHasAsScala(javaMap).asScala
    println(javaMap.getClass)
    println(scalaMap.getClass)

  }

  def main(args: Array[String]): Unit = {
    scalaCollection2JavaCollection()
    println("-------------------------------")
    javaCollection2ScalaCollection()
  }

  case class Person(name: String, age: Int)
}
