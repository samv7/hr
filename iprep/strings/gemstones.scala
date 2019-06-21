import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import scala.collection.mutable.HashMap

object Solution {

    // Complete the gemstones function below.
    def gemstones(arr: Array[String]): Int = {

        val letterCount : HashMap[Char, Int] = HashMap.empty[Char, Int]
        var gems = 0

        for (i <- 0 until arr.length) {
            val s = arr(i).toSet
            for (c : Char <- arr(i).toSet) {
                letterCount(c) = 1+letterCount.getOrElse(c, 0)
                if (letterCount.getOrElse(c, 0) == arr.size) {
                    gems += 1
                }
            }

        }

        return gems


    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = stdin.readLine.trim.toInt

        val arr = Array.ofDim[String](n)

        for (i <- 0 until n) {
            val arrItem = stdin.readLine
            arr(i) = arrItem}

        val result = gemstones(arr)

        printWriter.println(result)

        printWriter.close()
    }
}
