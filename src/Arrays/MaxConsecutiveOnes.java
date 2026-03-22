package Arrays;

import com.sun.tools.javac.Main;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] inputArray = {1,0,1,1,1,1,0,1,1};
        System.out.printf("My Max Consecutive Values "+maxConecutiveOnes(inputArray));
    }

    public static int maxConecutiveOnes(int[] input) {
        int result = 0;
        int intermediateResult = 0;
        for (int i = 0; i < input.length; i +=1) {
            if (input[i] != 0) {
                intermediateResult += 1;
            } else {
                if (intermediateResult > result ){
                    result = intermediateResult;
                }
                intermediateResult = 0;
            }
        }

        return Math.max(result, intermediateResult);
    }
}
