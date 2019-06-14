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

    // Complete the marsExploration function below.
    def marsExploration(s: String): Int = {

        var count = 0
        for (i <- 0 until s.length) {

            if (i % 3 == 1) {
                if (s.charAt(i) != 'O') { count += 1}
            } else { 
                if (s.charAt(i) != 'S') { count += 1}
            }
        }
        
        return count

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val s = stdin.readLine

        val result = marsExploration(s)

        printWriter.println(result)

        printWriter.close()
    }
}
