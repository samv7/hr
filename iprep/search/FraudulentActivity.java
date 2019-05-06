import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.Comparator;

public class FraudulentActivity {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
      int notifications = 0;

      MedianHeap medianHeap = new MedianHeap(d);

      for (int i=0; i<d; i++) {
        medianHeap.add(expenditure[i]);
      }

      for (int i=d; i<expenditure.length; i++) {
        if (expenditure[i] >= 2 * medianHeap.getMedian()) {
          notifications += 1;
        }
        medianHeap.remove(expenditure[i-d]); //delete oldest value from window

        medianHeap.add(expenditure[i]);
      }
      return notifications;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

class MedianHeap {

  PriorityQueue minHeap;
  PriorityQueue maxHeap;


  public MedianHeap(int size) {
    this.minHeap = new PriorityQueue<Integer>();
    this.maxHeap = new PriorityQueue<Integer>(size, Collections.reverseOrder());
  }

  public void add(int value) {

    if ( getMedian() == -1 ) {
      this.minHeap.add(value);
      return;
    }

    if (value <= getMedian() ) {
      this.maxHeap.add(value);
    } else {
      this.minHeap.add(value);
    }

    if (this.maxHeap.size() + 2 <= this.minHeap.size() ) {
      int top = (int)this.minHeap.peek();
      this.minHeap.remove(top);
      this.maxHeap.add(top);
    } else if (this.maxHeap.size() >= this.minHeap.size() + 2 ) {
      int top = (int)this.maxHeap.peek();
      this.maxHeap.remove(top);
      this.minHeap.add(top);
    }
  }

  public void remove(int value) {
    int sizeMin = this.minHeap.size();
    int sizeMax = this.maxHeap.size();

    if (sizeMin == sizeMax) {
      if (this.maxHeap.contains(value) ) {
        this.maxHeap.remove(value);
      } else {
        this.minHeap.remove(value);
      }
    } else {
      if (sizeMin > sizeMax) {
        if (this.minHeap.contains(value)) {
          this.minHeap.remove(value);
        } else {
          this.maxHeap.remove(value);
          int median = (int)this.minHeap.peek();
          this.minHeap.remove(median);
          this.maxHeap.add(median);
        }
      } else {
        if (this.maxHeap.contains(value)) {
          this.maxHeap.remove(value);
        } else {
          this.minHeap.remove(value);
          int median = (int)this.maxHeap.peek();
          this.maxHeap.remove(median);
          this.minHeap.add(median);
        }
      }

      if (this.maxHeap.size() + 2 <= this.minHeap.size() ) {
        int top = (int)this.minHeap.peek();
        this.minHeap.remove(top);
        this.maxHeap.add(top);
      } else if (this.maxHeap.size() >= this.minHeap.size() + 2 ) {
        int top = (int)this.maxHeap.peek();
        this.maxHeap.remove(top);
        this.minHeap.add(top);
      }
    }
  }

  public double getMedian() {

    if (this.maxHeap.size()==0 && this.minHeap.size()==0) {
      return -1;
    }

    if (this.maxHeap.size()==this.minHeap.size()) {
      return ((int)this.maxHeap.peek()+(int)this.minHeap.peek()) / 2.;
    } else {
      if (this.maxHeap.size()>this.minHeap.size()) {
        int median = (int)this.maxHeap.peek();
        return median;
      } else {
        int median = (int)this.minHeap.peek();
        return median;
      }
    }
  }
  @Override public String toString() {
    return this.maxHeap.toString() + " : " + this.minHeap.toString();
  }

}
