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

    // Complete the camelcase function below.
    def camelcase(s: String): Int = {

        return 1+s.count(_.isUpper)
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val s = stdin.readLine

        val result = camelcase(s)

        printWriter.println(result)

        printWriter.close()
    }
}
