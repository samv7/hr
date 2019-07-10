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

object Solution {

    // Complete the maximumPerimeterTriangle function below.
    def maximumPerimeterTriangle(sticks: Array[Int]): Array[Int] = {


        quickSort[Int](sticks)(Ordering[Int].reverse)

        for (i <- 0 until sticks.length-2) {

            if (sticks(i) < sticks(i+1) + sticks(i+2)) {
                val out = sticks.slice(i,i+3)
                quickSort(out)
                return out
            }
        }

        return Array(-1)



    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = stdin.readLine.trim.toInt

        val sticks = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = maximumPerimeterTriangle(sticks)

        printWriter.println(result.mkString(" "))

        printWriter.close()
    }
}
