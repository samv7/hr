import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.collection.parallel.immutable._
import scala.collection.parallel.mutable._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    def getWays(n: Int, c: Array[Int]): Long = {
    // Write your code here

        scala.util.Sorting.quickSort(c)

        val D = Array.ofDim[Long](c.size, n+1)
        for (j <- 0 until c.size) {
            if (c(j) <= n) {
                D(j)(c(j)) = 1
            }
        }


        for (j <- 1 until n+1) {
            for (i <- 0 until c.size) {
                for (k <- i until c.size) {
                    if (D(i)(j) > 0 && j+c(k) <= n ) {
                        D(k)(j+c(k)) += D(i)(j)
                    }
                }
            }
        }

        var ans = 0.toLong
        for (j <- 0 until c.size) {
            ans += D(j)(n)
        }
        return ans
    }

}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

        val n = firstMultipleInput(0).toInt

        val m = firstMultipleInput(1).toInt

        val c = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        val ways = Result.getWays(n, c)

        printWriter.println(ways)

        printWriter.close()
    }
}
