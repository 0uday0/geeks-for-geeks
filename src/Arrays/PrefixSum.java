package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrefixSum {
    public static void main(String[] args) {
        int[] input = {2,8,3,9,6,5,4};
        int[] sums = findSums(input);
        int[][] range = {{0,2},{1,3},{2,6}};
        int[] weightedSumPrefix = weightedPrefixSums(input);
        System.out.println("My Range Queries are "+ Arrays.deepToString(range));
        for (int index = 0; index < range.length; index +=1) {
            System.out.println("Sum for the given Range "+Arrays.toString(range[index])+" "+getSumOfElementsInGivenRange(range[index][0],range[index][1],sums));
            System.out.println("Weighted Sum of the given Range "+Arrays.toString(range[index])+" "+getWeightedSumOfAGivenRange(range[index][0],range[index][1],sums));
            System.out.println("Weighted Sum of the given Range Efficient "+Arrays.toString(range[index])+" "+weightSumEfficient(range[index][0],range[index][1],weightedSumPrefix,sums));
        }
    }

    public static int[] findSums(int[] input) {
        int[] sums = new int[input.length];
        sums[0] = input[0];
        for (int index = 1 ; index < input.length; index +=1) {
            sums[index] = sums[index-1]+input[index];
        }
        return sums;

    }
    public static int getSumOfElementsInGivenRange(int startIndex,int endIndex,int[] sums) {
        if (startIndex ==0) return sums[endIndex];
        return sums[endIndex]-sums[startIndex-1];
    }

    public static int getWeightedSumOfAGivenRange(int startIndex,int endIndex,int[] sums) {
          int result = 0;
          for (int index = startIndex; index <= endIndex; index+=1) {
              int sum = getSumOfElementsInGivenRange(index,endIndex,sums);
              result+=sum;
          }
          return result;

    }

    public static int[] weightedPrefixSums(int[] input) {
        int size = input.length;
        int[] result = new int[size];
        result[0] = input[0];
        for (int index = 1; index < size; index += 1) {
            result[index] = (((index+1)*input[index]) + result[index-1]);
        }
        System.out.println("My weighted Prefix sums "+Arrays.toString(result));
        return result;

    }
    public static int weightSumEfficient(int startIndex,int endIndex,int[] weightedPrefixSums,int[] sums) {
        if (startIndex == 0) {
           return weightedPrefixSums[endIndex];
        }
        return weightedPrefixSums[endIndex] - ((startIndex-1) * (getSumOfElementsInGivenRange(startIndex,endIndex,sums)));
    }
}
