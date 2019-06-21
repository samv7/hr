import java.io._
import java.math._
import java.security._
import java.text._

import scala.collection.mutable.HashMap
import scala.collection.immutable.Set

object Solution {

    // Complete the gameOfThrones function below.
    def gameOfThrones(s: String): String = {

        val sCount : Map[Char,Int] = s.groupBy(identity).mapValues(_.size)

        val nonEvens = sCount.filter(t => t._2 % 2 == 1).size

        if (nonEvens <= 1) {
            return "YES"
        } else {
            return "NO"
        }


    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val s = stdin.readLine

        val result = gameOfThrones(s)

        printWriter.println(result)

        printWriter.close()
    }
}
