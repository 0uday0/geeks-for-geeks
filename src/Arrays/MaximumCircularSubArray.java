package Arrays;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MaximumCircularSubArray {
    public static void main(String[] args) {
        int[] input = {1,-2,3,-2};
        System.out.println(maxSumOfCircularArray(input));
    }
    public static int maxSumOfCircularArray(int[] sampleArray) {
        int totalSum = sampleArray[0];
        int maxSum = sampleArray[0];
        int maxSumEndingWithTheElement = sampleArray[0];
        int minSum = sampleArray[0];
        int minSumEndingWitheElement = sampleArray[0];
        for(int index = 1; index < sampleArray.length; index +=1) {
            int elem = sampleArray[index];
            totalSum+=elem;
            maxSumEndingWithTheElement = Math.max(elem,maxSumEndingWithTheElement+elem);
            maxSum = Math.max(maxSumEndingWithTheElement,maxSum);
            minSumEndingWitheElement = Math.min(elem,minSumEndingWitheElement+elem);
            minSum = Math.min(minSum,minSumEndingWitheElement);
        }
        if (maxSum < 0) {
           return maxSum;
        }
        return Math.max(maxSum,totalSum-minSum);


    }

}
