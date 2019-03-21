import java.io._
import java.math._
import java.security._
import java.text._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

class Store() {

    val countMap = new HashMap[Int,Int]().withDefaultValue(0)
    val groupCountMap = new HashMap[Int,Int]().withDefaultValue(0)

    def add(v : Int) {
        groupCountMap(countMap(v)) = max(0, groupCountMap(countMap(v))-1)
        countMap(v) = countMap(v) + 1
        groupCountMap(countMap(v)) += 1
    }

    def delete(v : Int) {
        groupCountMap(countMap(v)) = max(0, groupCountMap(countMap(v))-1)
        countMap(v) = max(0, countMap(v) - 1)
        groupCountMap(countMap(v)) += 1
    }

    def checkFreq(freq : Int) : Int = {
        if (groupCountMap.contains(freq) && groupCountMap(freq)>0) {
            return 1
        } else {
            return 0
        }
    }

}

object Solution {

    // Complete the freqQuery function below.
    def freqQuery(queries: Array[Array[Int]]): Array[Int] = {

        val store = new Store()
        val output = ListBuffer[Int]()
        for (arr <- queries) {
            var operation = arr(0)
            if (operation == 1) {
                store.add(arr(1))
            } else if (operation == 2) {
                store.delete(arr(1))
            } else if (operation == 3) {
                output += store.checkFreq(arr(1))
            }
        }

        return output.toArray

    }

    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val q = StdIn.readLine.trim.toInt

        val queries = Array.ofDim[Int](q, 2)

        for (i <- 0 until q) {
            queries(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
        }

        val ans = freqQuery(queries)

        printWriter.println(ans.mkString("\n"))

        printWriter.close()
    }
}
