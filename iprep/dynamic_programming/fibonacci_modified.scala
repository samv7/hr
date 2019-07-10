import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import scala.math.BigInt

object Solution {

    // Complete the fibonacciModified function below.
    def fibonacciModified(t1: Int, t2: Int, n: Int): BigInt = {

        if (n == 1) {
            return t1
        } else if (n==2) {
            return t2
        }

        var a = BigInt(t1)
        var b = BigInt(t2)
        var c = BigInt(0)

        for (i <- 3 until n+1) {
            c = a + (b*b)

            a = b
            b = c
        }

        return c
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val t1T2n = stdin.readLine.split(" ")

        val t1 = t1T2n(0).trim.toInt

        val t2 = t1T2n(1).trim.toInt

        val n = t1T2n(2).trim.toInt

        val result = fibonacciModified(t1, t2, n)

        printWriter.println(result)

        printWriter.close()
    }
}
