import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.collection.parallel.immutable._
import scala.collection.parallel.mutable._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Solution {

    // Complete the superReducedString function below.
    def superReducedString(s: String): String = {

        val buf = new StringBuilder
        buf += s.charAt(0)
        for (i <- 1 until s.length) {

            if (buf.length > 0 && s.charAt(i) == buf.last) {
                buf.deleteCharAt(buf.length - 1)
            } else {
                buf += s.charAt(i)
            }
        }
        return buf.toString match { case ""|null => "Empty String" case s => s }
    }

    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val s = StdIn.readLine

        val result = superReducedString(s)

        printWriter.println(result)

        printWriter.close()
    }
}
