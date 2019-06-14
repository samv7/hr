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

    // Complete the caesarCipher function below.
    def caesarCipher(s: String, k: Int): String = {

        val buf = new StringBuilder
        
        for (i <- 0 until s.length) {
            
            if (s.charAt(i).isLetter) {
                var alphaIdx = s.charAt(i).toInt - 65
                var shifted = 0
                if (s.charAt(i).isLower) {
                    alphaIdx -= 32
                    shifted = 32
                }

                shifted += ((alphaIdx + k )  % 26 ) + 65
                buf += shifted.toChar
            } else {
                buf += s.charAt(i)
            }
        }

        return buf.toString

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = stdin.readLine.trim.toInt

        val s = stdin.readLine

        val k = stdin.readLine.trim.toInt

        val result = caesarCipher(s, k)

        printWriter.println(result)

        printWriter.close()
    }
}
