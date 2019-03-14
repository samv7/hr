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

    // Complete the substrCount function below.
    def substrCount(n: Int, s: String): Long = {

        var count : Long = n

        //process even
        var i = 0
        for( i <- 0 to {n-2} ){
            var left = i
            var right = i+1
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)
            && s.charAt(i) == s.charAt(right) )
            {
                count += 1
                left -= 1
                right += 1
            }
        }


        //process odd
        for( i <- 1 to {n-2} ){
            var left = i-1
            var right = i+1
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right) &&
            s.charAt(i+1)==s.charAt(right) )
            {
                count += 1
                left -= 1
                right += 1
            }
        }

        return count


    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = stdin.readLine.trim.toInt

        val s = stdin.readLine

        val result = substrCount(n, s)

        printWriter.println(result)

        printWriter.close()
    }
}
