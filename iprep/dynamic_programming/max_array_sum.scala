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

    // Complete the maxSubsetSum function below.
    def maxSubsetSum(arr: Array[Int]): Int = {

        if (arr.size == 1) {
            return arr.last
        }

        if (arr.size == 2) {
            return Math.max(arr.sum, arr.max)
        }
        val D = Array.fill(arr.size+2)(0)

        for (i <-2 until D.size) {

            D(i) = Math.max(D(i-2)+arr(i-2), D(i-1))
        }

        return D.last
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = stdin.readLine.trim.toInt

        val arr = stdin.readLine.split(" ").map(_.trim.toInt)
        val res = maxSubsetSum(arr)

        printWriter.println(res)

        printWriter.close()
    }
}
