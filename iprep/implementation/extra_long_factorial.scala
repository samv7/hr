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

    // Complete the extraLongFactorials function below.
    def extraLongFactorials(n: Int) {

        var b = BigInt(1)
        for (i <- 1 until n+1) {
            b = b * i
        }

        println(b)
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val n = stdin.readLine.trim.toInt

        extraLongFactorials(n)
    }
}
