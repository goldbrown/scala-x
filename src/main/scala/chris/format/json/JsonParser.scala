package chris.format.json

import play.api.libs.json.Json

/**
 * @description:
 * @author: chris
 * @date: 2021/4/7
 */
object JsonParser {

  def convert2String(): Unit = {
    val animal = Animal("James", "Pig", List("eat", "sleep", "run"))
    // write to json string
    implicit val personWrites = Json.writes[Animal]
    val str = Json.toJson(animal)(personWrites)
    println(str)
  }

  def main(args: Array[String]): Unit = {
    parseJsonString()
    convert2String()
  }

  def parseJsonString() = {
    val rawJson = """{"name":"James","category":"Pig","hobby":["eat","sleep","run"]}"""
    val json = Json.parse(rawJson)
    println(json)
    // query field
    val name = (json \ "name").get
    println("name is " + name)
    // construct to case class
    implicit val animalReads = Json.reads[Animal]
    val animal = Json.fromJson(json)(animalReads).get
    println("name is " + animal.name)
  }

  case class Animal(name: String, category: String, hobby: List[String])

}
