import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import scala.util.Sorting.quickSort
import scala.math.pow

object Solution {

    // Complete the marcsCakewalk function below.
    def marcsCakewalk(calorie: Array[Long]): Long = {

        quickSort[Long](calorie)(Ordering[Long].reverse)
        return (calorie.view.zipWithIndex foldLeft 0.toLong) {case (acc,(value,index)) => acc + scala.math.pow(2,index).toLong*value }

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = stdin.readLine.trim.toInt

        val calorie = stdin.readLine.split(" ").map(_.trim.toLong)
        val result = marcsCakewalk(calorie)

        printWriter.println(result)

        printWriter.close()
    }
}
