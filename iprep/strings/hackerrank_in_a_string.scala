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

    // Complete the hackerrankInString function below.
    def hackerrankInString(s: String): String = {

        var progress = 0
        val target = "hackerrank"

        for (i <- 0 until s.length) {

            if (s.charAt(i) == target.charAt(progress)) {
                progress += 1
            }

            if (progress >= target.length) {
                return "YES"
            }
        }

        return "NO"
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val q = stdin.readLine.trim.toInt

        for (qItr <- 1 to q) {
            val s = stdin.readLine

            val result = hackerrankInString(s)

            printWriter.println(result)
        }

        printWriter.close()
    }
}
