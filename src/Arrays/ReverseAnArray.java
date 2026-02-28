package Arrays;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] input = {10,5,7,30    };
        int[] inputTwo = {10,5,7,30    };
        System.out.println(Arrays.toString(reverseAnArray(input)));
        System.out.println(Arrays.toString(cleanerReversingOfArray(inputTwo)));
    }
    public static int[] reverseAnArray(int[] arr) {
        int sizeOfTheArray = arr.length;
        if (sizeOfTheArray == 0 || sizeOfTheArray == 1) {
            return arr;
        }
        int midPointOfTheArray = sizeOfTheArray /2;
        for (int i = 0; i < midPointOfTheArray; i +=1) {
            int elementPresentInTheRightHalf = arr[sizeOfTheArray - i-1];
            int elementPresentInTheLeftHalf = arr[i];
            arr[i] = elementPresentInTheRightHalf;
            arr[sizeOfTheArray-i-1] = elementPresentInTheLeftHalf;
        }
        return arr;

    }

    public static int[] cleanerReversingOfArray(int[] arr) {
        int size = arr.length;
        int low = 0;
        int high = size -1;
        while (low < high) {
            int leftEnd  =arr[low];
            int rightEnd = arr[high];
            arr[low] = rightEnd;
            arr[high] = leftEnd;
            low+=1;
            high -= 1;
        }
        return arr;
    }
}
