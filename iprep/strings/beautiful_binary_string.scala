import java.io._
import java.math._
import java.security._
import java.text._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import scala.collection.mutable.ListBuffer

object Solution {

    // Complete the beautifulBinaryString function below.
    def beautifulBinaryString(b: String): Int = {

        var count = 0
        var x = b.charAt(0)
        var y = b.charAt(1)
        for (i <- 2 until b.length) {
            if (x=='0' && y=='1' && b.charAt(i)=='0') {
                count += 1
                x=y
            } else {
                x=y
                y=b.charAt(i)
            }

        }
        return count
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = stdin.readLine.trim.toInt

        val b = stdin.readLine

        val result = beautifulBinaryString(b)

        printWriter.println(result)

        printWriter.close()
    }
}
