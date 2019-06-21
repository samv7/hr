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

    // Complete the theLoveLetterMystery function below.
    def theLoveLetterMystery(s: String): Int = {

        var edits = 0
        for (i <- 0 until s.length/2) {

            val left = i
            val right = s.length - i - 1

            edits += Math.abs(s.charAt(left) - s.charAt(right))

        }

        return edits

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val q = stdin.readLine.trim.toInt

        for (qItr <- 1 to q) {
            val s = stdin.readLine

            val result = theLoveLetterMystery(s)

            printWriter.println(result)
        }

        printWriter.close()
    }
}
