## Ivy
library dependency:

"org.scalaj" %% "scalaj-http" % "2.4.1"

see https://github.com/scalaj/scalaj-http for the document

## 
GET method demo
```scala
import java.nio.file.{Files, Paths}
import scalaj.http.{Http, MultiPart}
  def getCatPic() = {
    // open api for searching cat pictures: https://documenter.getpostman.com/view/5578104/RWgqUxxh
    val getResp = Http("https://api.thecatapi.com/v1/images/search").param("page", 1.toString)
      .header("Content-Type", "application/json").param("limit", 5.toString).asString
    val body = getResp.body
    println(body)
  }
```

POST method demo
```scala
import java.nio.file.{Files, Paths}
import scalaj.http.{Http, MultiPart}
  def uploadCatPic(): Unit = {
    val data :Array[Byte] = Files.readAllBytes(Paths.get("/Users/chris/Downloads/9ccXTANkb.jpg")) // your file path in your local system
    val httpResp = Http("https://api.thecatapi.com/v1/images/upload").header("Content-Type", "multipart/form-data")
      .header("x-api-key", "DEMO-API-KEY").postMulti(MultiPart("file", "/Users/chris/Downloads/9ccXTANkb.jpg", "image/jpeg", data)).asString
    val body = httpResp.body
    println(body)
  }
```