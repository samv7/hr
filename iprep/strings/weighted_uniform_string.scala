import java.io._
import java.math._
import java.security._
import java.text._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import scala.collection.mutable.Set

object Solution {

    // Complete the weightedUniformStrings function below.
    def weightedUniformStrings(s: String, queries: Array[Int]): Array[String] = {

        var charSum = 0
        var prevChar = ' '
        val U: Set[Int] = Set.empty[Int]

        for (i <- 0 until s.length) {
            if (s.charAt(i) != prevChar) {
                charSum = weight(s.charAt(i))
            } else {
                charSum += weight(s.charAt(i))
            }
            prevChar = s.charAt(i)
            U += charSum
        }

        return queries.map(i => if (U.contains(i)) { "Yes" } else { "No" })
    }

    def weight(c : Char) : Int = {
        return c.toInt - 96
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val s = stdin.readLine

        val queriesCount = stdin.readLine.trim.toInt

        val queries = Array.ofDim[Int](queriesCount)

        for (i <- 0 until queriesCount) {
            val queriesItem = stdin.readLine.trim.toInt
            queries(i) = queriesItem}

        val result = weightedUniformStrings(s, queries)

        printWriter.println(result.mkString("\n"))

        printWriter.close()
    }
}
