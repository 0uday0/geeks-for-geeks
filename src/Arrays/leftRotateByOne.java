package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leftRotateByOne {
    public static void main(String[] args) {
       int[] input = {1,2,3,4};
        int[] result = leftRotateByOnePlace(input);
        System.out.println("The result is "+Arrays.toString(result));
    }


    public static int[] leftRotateByOnePlace(int[] input) {
        int size = input.length;
        int firstElement = input[0];
        for (int  i = 1; i < size ; i += 1) {
            input[i-1] = input[i];
        }
        input[size-1] = firstElement;
        return input;
    }
}
