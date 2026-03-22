package Arrays;

import java.sql.Array;
import java.util.*;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] input = {5,4,-1,7,8};
        System.out.println(maxSum(input));

    }

   public static int maxSum(int[] input) {
        int maxSum = input[0];
        int lastMax = input[0];
        for (int i = 1; i < input.length; i+=1) {
            int maxSumOfSubArrayEndingWithThisElement = Math.max(input[i],lastMax+input[i]);
            lastMax = maxSumOfSubArrayEndingWithThisElement;
            if (maxSum < maxSumOfSubArrayEndingWithThisElement){
                maxSum = maxSumOfSubArrayEndingWithThisElement;
            }
        }
        return maxSum;
   }

}
