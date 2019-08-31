import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {

    // Complete the maxSubarray function below.
    def maxSubarray(arr: Array[Int]): Array[Int] = {

        val D = Array.fill(arr.size)(0)
        D(0) = arr(0)
        for (i <- 1 until arr.size) {
            if ( arr(i) > D(i-1) + arr(i) ) {
                D(i) =  arr(i)
            } else {
                D(i) = D(i-1) + arr(i)
            }
        }

        val arrNonNeg = arr.filter(_ >= 0)
        val maxSubSeqSum = if (arrNonNeg.size > 0) {
            arrNonNeg.sum
        } else {
            arr.max
        }
        return Array(D.max, maxSubSeqSum)
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val t = stdin.readLine.trim.toInt

        for (tItr <- 1 to t) {
            val n = stdin.readLine.trim.toInt

            val arr = stdin.readLine.split(" ").map(_.trim.toInt)
            val result = maxSubarray(arr)

            printWriter.println(result.mkString(" "))
        }

        printWriter.close()
    }
}
