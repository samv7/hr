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

    // Complete the funnyString function below.
    def funnyString(s: String): String = {

        val r = s.reverse

        val diffS = s.toSeq.map(_.toInt).sliding(2).map { case Seq(x, y, _*) => Math.abs(y - x) }.toArray
        val diffR = r.toSeq.map(_.toInt).sliding(2).map { case Seq(x, y, _*) => Math.abs(y - x) }.toArray

        for (i <- 0 until diffS.length) {

            if (diffS(i) != diffR(i)) {
                return "Not Funny"
            }
        }

        return "Funny"

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val q = stdin.readLine.trim.toInt

        for (qItr <- 1 to q) {
            val s = stdin.readLine

            val result = funnyString(s)

            printWriter.println(result)
        }

        printWriter.close()
    }
}
