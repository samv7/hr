import java.io._
import java.math._
import java.security._
import java.text._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable.Set

object Solution {

    // Complete the minimumNumber function below.
    def minimumNumber(n: Int, password: String): Int = {
        // Return the minimum number of characters to make the password strong

        val special_characters = Set('!','@','#','$','%','^','&','*','(',')','-','+')
        
        val lowerCount = Math.min(1, password.count(_.isLower))
        val upperCount = Math.min(1, password.count(_.isUpper))
        val digitCount = Math.min(1, password.count(_.isDigit))
        val specialCount = Math.min(1, password.count(special_characters.contains))

        val lengthGap = Math.max(6-password.length, 0)

        return Math.max(lengthGap, 4- (lowerCount + upperCount + digitCount + specialCount))

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = stdin.readLine.trim.toInt

        val password = stdin.readLine

        val answer = minimumNumber(n, password)

        printWriter.println(answer)

        printWriter.close()
    }
}
