import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {

        int[] tmpArr = new int[arr.length];
        long ans = mergeSort(arr, tmpArr, 0, arr.length-1);

        return ans;
    }

    static long mergeSort(int[] arr, int[] outputArr, int j, int k) {

        if ( (k-j) < 1 ) {
            return 0;
        } else {
            int mid = j+(int)Math.floor((k-j)/2);

            long A=mergeSort(arr, outputArr, j, mid );
            long B=mergeSort(arr, outputArr, mid+1, k);

            return A+B+mergeAndCount(arr, outputArr, j, mid, mid+1, k);
        }
    }

    static long mergeAndCount(int[] arr, int[] outputArr, int leftIdx, int leftEnd, int rightIdx, int rightEnd) {

        int outputIdx = leftIdx;
        long swapCount = 0;
        for (int i = leftIdx; i<=rightEnd; i++) {
            outputArr[i] = arr[i];
        }
        while (leftIdx <= leftEnd && rightIdx <= rightEnd) {
            if (outputArr[leftIdx] <= outputArr[rightIdx] ) {
                arr[outputIdx++] = outputArr[leftIdx++];
            } else if (outputArr[leftIdx] > outputArr[rightIdx] ) {
                arr[outputIdx++] = outputArr[rightIdx++];
                swapCount += rightIdx - outputIdx;
            }
        }
        while (leftIdx <= leftEnd) {
            arr[outputIdx++] = outputArr[leftIdx++];
        }
        while (rightIdx <= rightEnd) {
            arr[outputIdx++] = outputArr[rightIdx++];
        }

        return swapCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
