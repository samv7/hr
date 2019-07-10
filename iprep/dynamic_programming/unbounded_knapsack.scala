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

    // Complete the unboundedKnapsack function below.
    def unboundedKnapsack(k: Int, arr: Array[Int]): Int = {

        val D = Array.fill[Int](k+1)(0)
        arr.foreach( i=> if (i < D.size) {  D(i) = 1} )
        D(0) = 1

        for (i <- 1 until k+1) {
          for (j <- 0 until arr.size) {
            if (i - arr(j) >= 0 && D(i - arr(j)) == 1) {
              D(i) = 1
            }
          }
        }

        for (i <- (D.size - 1) to 0 by -1){
          if (D(i) == 1) {
            return i
          }
        }

        return 0

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val t = stdin.readLine.trim.toInt

        for (i <- 0 until t) {
            val nk = stdin.readLine.split(" ")

            val n = nk(0).trim.toInt

            val k = nk(1).trim.toInt

            val arr = stdin.readLine.split(" ").map(_.trim.toInt)
            val result = unboundedKnapsack(k, arr)

            printWriter.println(result)
        }

        printWriter.close()
    }
}
