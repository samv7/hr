import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import scala.annotation.tailrec
import scala.util.Sorting.quickSort

object Solution {

    // Complete the pairs function below.
    def pairs(k: Int, arr: Array[Int]): Int = {
        quickSort(arr)
        var total = 0
        for (i <- 0 until arr.length) {

            var idx = binarySearch(arr, arr(i)+k, i, arr.length-1)
            if (idx != -1) {
                total +=1
            }

        }
        return total

    }

    //@scala.annotation.tailrec
    def binarySearch(arr: Array[Int], k : Int, start : Int, end : Int) : Int = {
        if (end - start <= 1 ) {
            if (arr(start)==k)
                return start
            else if (arr(end)==k)
                return end
            else
                return -1
        } else {
            val mid = start + (end - start)/2
            if (k == arr(mid)) {
                mid
            } else {
                if (k < arr(mid))
                    return binarySearch(arr, k, start, mid)
                else
                    return binarySearch(arr, k, mid, end)
            }
        }
    }


    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val nk = stdin.readLine.split(" ")

        val n = nk(0).trim.toInt

        val k = nk(1).trim.toInt

        val arr = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = pairs(k, arr)

        printWriter.println(result)

        printWriter.close()
    }
}
