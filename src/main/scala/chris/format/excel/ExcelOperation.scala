package chris.format.excel

import java.io.{File, FileInputStream}
import java.nio.file.{Files, Paths}
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream
import java.io.OutputStream

/**
 * @description: for the document, see https://poi.apache.org/components/spreadsheet/quick-guide.html#NewWorkbook
 * @author: chris
 * @date: 2021/4/8
 */
object ExcelOperation {

  def main(args: Array[String]): Unit = {
//    readExcel("/Users/chris/SelfCode/scala-x/src/main/scala/chris/format/excel/person.xlsx")
    writeExcel("/Users/chris/SelfCode/scala-x/src/main/scala/chris/format/excel/WritePerson.xlsx")
  }

  def readExcel(path: String):Unit = {

    val myData = new File(path)

    val fis = new FileInputStream(myData)

    val myWorkbook = new XSSFWorkbook(fis)

    val mySheet = myWorkbook.getSheetAt(0)  // get the first sheet
    var res = Array[(String, Double)]()

    val rowNum = mySheet.getLastRowNum // get the last row num
    for (i <- 0 to rowNum) {
      val row = mySheet.getRow(i)
      val name = row.getCell(0).getStringCellValue
      val age = row.getCell(1).getNumericCellValue
      res :+= (name, age)
    }
    res.map(println(_))
  }

  def writeExcel(filename: String): Unit = {
    val list = List(Person("Tina", 12), Person("Carton", 23))
    val wb = new XSSFWorkbook
    val sheet = wb.createSheet("sheet 1")
    list.zipWithIndex.map {case (person, index) => {
      val row = sheet.createRow(index)
      var cell = row.createCell(0)
      cell.setCellValue(person.name)

      cell = row.createCell(1)
      cell.setCellValue(person.age)
    }}

    try {
      val fileOut = new FileOutputStream(filename)
      try wb.write(fileOut)
      finally if (fileOut != null) fileOut.close()
    }
  }

  case class Person(name: String, age: Int)
}
