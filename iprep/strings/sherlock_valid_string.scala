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
import scala.collection.mutable.Set
import scala.math.abs
import scala.math.max
import scala.math.min

object Solution {

    // Complete the isValid function below.
    def isValid(s: String): String = {
        val countMap: HashMap[Char, Int] = new HashMap()
        for (c <- s) {
            if (countMap.contains(c))
                countMap(c) = countMap(c) + 1
            else
                countMap.+= ((c, 1))
        }

        val groupCountMap: HashMap[Int, Int] = new HashMap()
        for ((k,v) <- countMap) {
            if (groupCountMap.contains(v))
                groupCountMap(v) = groupCountMap(v) + 1
            else
                groupCountMap.+= ((v, 1))
        }


        if (groupCountMap.size == 1)
            return "YES"
        else if (groupCountMap.size == 2) {
            if (groupCountMap.contains(1) && groupCountMap(1)==1 )
                return "YES"
            else if (groupCountMap.keys.max - groupCountMap.keys.min == 1 &&
                groupCountMap(groupCountMap.keys.max)==1)
                return "YES"
            else
                return "NO"
        } else
            return "NO"

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val s = stdin.readLine

        val result = isValid(s)

        printWriter.println(result)

        printWriter.close()
    }
}
