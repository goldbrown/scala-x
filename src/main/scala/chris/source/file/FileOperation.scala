package chris.source.file

import java.nio.file.{Files, Paths}

/**
 * @description:
 * @author: chris
 * @date: 2021/4/7
 */
object FileOperation {
  def main(args: Array[String]): Unit = {
    readSmallFile("/Users/chris/SelfCode/scala-x/src/main/scala/chris/source/SmallFile.txt")
    readLargeFile("/Users/chris/SelfCode/scala-x/src/main/scala/chris/source/LargeFile.txt")
    writeFile("/Users/chris/SelfCode/scala-x/src/main/scala/chris/source/NewFile.txt")
  }


  // read file
  def readSmallFile(filename: String) = {
    // small file
    val path = Paths.get(filename)
    val line = Files.readAllLines(path).get(0) // read all lines
    println(line)
  }

  def readLargeFile(filename: String) = {
    // read large file
    val path = Paths.get(filename)
    val reader = Files.newBufferedReader(path)
    val content = reader.readLine() // read one line
    println(content)
  }

  // write file
  def writeFile(filename: String) = {
    val fileContent = "hello, scala"
    val path = Paths.get(filename)
    Files.write(path, fileContent.getBytes())
    println("write file success")
  }
}
