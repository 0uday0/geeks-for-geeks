package Arrays;

import com.sun.security.jgss.GSSUtil;

public class SlidingWindowTechnique {

    public static void main(String[] args) {
        int[] input = {5,-10,6,90,3};
        System.out.println("My result"+maxSumOfKConsecutiveElements(input,2));
    }

    public static int maxSumOfKConsecutiveElements(int[] input, int k) {

        int result = 0;
        int size = input.length;
        int intermediateSum = 0;
        for (int i = 0; i < k; i +=1) {
            intermediateSum += input[i];
        }
        if (intermediateSum > result) {
            result = intermediateSum;
        }
        int startIndex = 1;
        while(startIndex+k<size) {
            intermediateSum -= input[startIndex-1];
            intermediateSum += input[startIndex+k-1];
            if (intermediateSum > result) {
                result = intermediateSum;
            }
            startIndex += 1;
        }
        return result;
    }
}
