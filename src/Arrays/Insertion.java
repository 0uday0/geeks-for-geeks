package Arrays;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] sampleArray = new int[9];
        sampleArray[0] =1;
        sampleArray[1] = 3;
        sampleArray[2] = 4;
        insertIntoAnArray(sampleArray,2,1,9,3);
    }
    public static int insertIntoAnArray(int[] arr,int elementToBeInserted, int indexAtWhichItNeedsToInserted,int capacityOfArray,int currentSizeOfArray ){

        if (currentSizeOfArray == capacityOfArray) {
            return currentSizeOfArray;
        }
        for (int i = currentSizeOfArray-1; i >= indexAtWhichItNeedsToInserted; i--) {
            arr[i+1] = arr[i];
        }
        arr[indexAtWhichItNeedsToInserted] =elementToBeInserted;
        System.out.println(Arrays.toString(arr));
        return currentSizeOfArray+1;

    }
}
