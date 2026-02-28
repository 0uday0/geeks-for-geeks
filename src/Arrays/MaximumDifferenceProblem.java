package Arrays;

import java.util.Arrays;

public class MaximumDifferenceProblem {
    public static void main(String[] args) {
        int[] input = {30,10,8,2};
        System.out.println(maximumDifference(input));

    }
    public static int maximumDifference(int[] arr) {
        // j > i;
        int maxDifference = arr[1] - arr[0];
        int minimumEncounteredSoFar = arr[0];
        int size = arr.length;
        for (int i = 1; i < size ; i+= 1) {
            if ((arr[i] - minimumEncounteredSoFar) > maxDifference) {
                maxDifference = arr[i] - minimumEncounteredSoFar;
            }
            if (arr[i] < minimumEncounteredSoFar) {
                minimumEncounteredSoFar = arr[i];
            }
        }
        return maxDifference;
    }
}
