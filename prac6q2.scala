import scala.io.StdIn

object StudentRecords {

  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty."))
    } else if (marks < 0 || totalMarks < 0) {
      (false, Some("Marks and total possible marks must be positive integers."))
    } else if (marks > totalMarks) {
      (false, Some("Marks cannot exceed total possible marks."))
    } else {
      (true, None)
    }
  }

 
  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    println("Enter student's name:")
    val name = StdIn.readLine()
    println("Enter student's marks:")
    val marks = StdIn.readInt()
    println("Enter total possible marks:")
    val totalMarks = StdIn.readInt()

    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _            => 'D'
    }

    (name, marks, totalMarks, percentage, grade)
  }

  def printStudentRecord(student: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = student
    println(s"Student Name: $name")
    println(s"Marks: $marks/$totalMarks")
    println(s"Percentage: ${"%.2f".format(percentage)}%")
    println(s"Grade: $grade")
  }

  
  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var valid = false
    var student: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'D')

    while (!valid) {
      val studentInfo = getStudentInfo()
      val (name, marks, totalMarks, _, _) = studentInfo
      val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
      if (isValid) {
        valid = true
        student = studentInfo
      } else {
        println(errorMessage.get)
      }
    }

    student
  }

  def main(args: Array[String]): Unit = {
    val student = getStudentInfoWithRetry()
    printStudentRecord(student)
  }
}
