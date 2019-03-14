
import scala.io.StdIn.readInt
import scala.collection.mutable.Queue
import scala.collection.mutable.ArrayStack

class Queue2Stacks() {

    val stack1: ArrayStack[Int] = ArrayStack()
    val stack2: ArrayStack[Int] = ArrayStack()

    def enqueue(value : Int) {
        this.stack1.push(value)
    }

    def dequeue() {
        this.rebalance()
        this.stack2.pop()
    }

    def rebalance() {
        if (this.stack2.length == 0) {
            while (this.stack1.length > 0) {
                this.stack2.push(this.stack1.pop())
            }
        }
    }

    def peek() : Int = {
        this.rebalance()
        return this.stack2.top
    }
}

object Solution {

    def main(args: Array[String]) {
        val scanner = new java.util.Scanner(System.in)
        val n = scanner.nextInt()

        val queue = new Queue2Stacks()
        val output = new StringBuilder

        var i = 0
        for( i <- 0 to {n-1} ){

            var operation = scanner.nextInt()
            if (operation == 1) {
                queue.enqueue(scanner.nextInt())
            } else if (operation == 2) {
                queue.dequeue()
            } else if (operation == 3) {
                output.append(queue.peek())
                output.append("\n")
            }
        }
        System.out.println(output)
    }
}
