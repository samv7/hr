import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        int[] numInDegrees = new int[arr.length];
        ArrayList<Integer> sourcesIdx = new ArrayList<Integer>();
        ArrayList<Integer> newSourcesIdx = new ArrayList<Integer>();
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

        int[] candies = new int[arr.length];
        int level = 1;
        int visitCount = 0;
        long sum = 0;

        if (arr.length == 1) {return 1;}
        //build numInDegrees
        for (int i=1; i<arr.length; i++) {
            numInDegrees[i] = 0; candies[i]=0; visited.put(i, false);
        }

        for (int i=0; i<arr.length; i++) {
            if (0<i && arr[i-1]>arr[i]) {
                numInDegrees[i-1] += 1;
            }
            if (i<arr.length-1 && arr[i]<arr[i+1]) {
                numInDegrees[i+1] += 1;
            }
        }
        for (int i=0; i<arr.length; i++) {
            if (numInDegrees[i]==0) { sourcesIdx.add(i); }
        }

        while (visitCount < arr.length) {

            while (sourcesIdx.size() > 0) {
                int u = sourcesIdx.remove(0);
                candies[u] = level;
                visitCount += 1;

                if (u > 0 && arr[u-1]>arr[u]) {
                    numInDegrees[u-1] -= 1;
                    if (numInDegrees[u-1] == 0) {
                        newSourcesIdx.add(u-1);
                    }
                }

                if (u < arr.length - 1 && arr[u]<arr[u+1]) {
                    numInDegrees[u+1] -= 1;
                    if (numInDegrees[u+1] == 0) {
                        newSourcesIdx.add(u+1);
                    }
                }
            }
            level += 1;

            for (int i = 0 ; i<newSourcesIdx.size();i++){
                sourcesIdx.add(newSourcesIdx.get(i)) ;
            }
            newSourcesIdx.clear();
        }

        for (int i=0; i<arr.length; i++) {
            sum += candies[i];
        }

        return sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
