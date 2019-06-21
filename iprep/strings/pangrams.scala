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

    // Complete the pangrams function below.
    def pangrams(s: String): String = {

        if (s.replace(" ", "").toLowerCase.toSet.size == 26) {
            return "pangram"
        } else {
            return "not pangram"
        }


    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val s = stdin.readLine

        val result = pangrams(s)

        printWriter.println(result)

        printWriter.close()
    }
}
