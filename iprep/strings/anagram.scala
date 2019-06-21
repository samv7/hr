import java.io._
import java.math._
import java.security._
import java.text._
import java.util.regex._
import java.util.stream._

import scala.collection.mutable.HashMap
import scala.collection.immutable.Set

object Solution {

    // Complete the anagram function below.
    def anagram(s: String): Int = {

        if (s.length % 2 == 1) { return -1 }

        val s1 = s.substring(0, s.length / 2)
        val s2 = s.substring(s.length / 2, s.length)

        val s1Count : Map[Char,Int] = s1.groupBy(identity).mapValues(_.size)
        val s2Count : Map[Char,Int] = s2.groupBy(identity).mapValues(_.size)

        var edits = 0

        for ((k,v) <- s2Count) {
            edits += Math.max(0, v - s1Count.getOrElse(k, 0))
        }

        return edits

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val q = stdin.readLine.trim.toInt

        for (qItr <- 1 to q) {
            val s = stdin.readLine

            val result = anagram(s)

            printWriter.println(result)
        }

        printWriter.close()
    }
}
