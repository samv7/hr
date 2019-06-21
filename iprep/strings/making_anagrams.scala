import java.io._
import java.math._
import java.security._
import java.text._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import scala.collection.mutable.HashMap
import scala.collection.immutable.Set

object Solution {

    // Complete the makingAnagrams function below.
    def makingAnagrams(s1: String, s2: String): Int = {

        val s1Count : Map[Char,Int] = s1.groupBy(identity).mapValues(_.size)
        val s2Count : Map[Char,Int] = s2.groupBy(identity).mapValues(_.size)

        var edits = 0

        for ((k,v) <- s2Count) {
            edits += Math.max(0, v - s1Count.getOrElse(k, 0))
        }

        for ((k,v) <- s1Count) {
            edits += Math.max(0, v - s2Count.getOrElse(k, 0))
        }

        return edits

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val s1 = stdin.readLine

        val s2 = stdin.readLine

        val result = makingAnagrams(s1, s2)

        printWriter.println(result)

        printWriter.close()
    }
}
