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
     * Complete the 'stockmax' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY prices as parameter.
     */

    def stockmax(prices: Array[Int]): Long = {
    // Write your code here

        var totalProfit : Long = 0

        var curMaxPrice = prices.last

        for(i <- prices.length - 2 to 0 by -1){

            curMaxPrice = max(curMaxPrice, prices(i))

            val profit = curMaxPrice - prices(i)

            if (profit > 0) {
                totalProfit += profit
            }
        }

        return totalProfit

    }

}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val t = StdIn.readLine.trim.toInt

        for (tItr <- 1 to t) {
            val n = StdIn.readLine.trim.toInt

            val prices = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
            val result = Result.stockmax(prices)

            printWriter.println(result)
        }

        printWriter.close()
    }
}
