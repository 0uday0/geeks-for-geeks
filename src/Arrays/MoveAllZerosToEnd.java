package Arrays;

import java.util.Arrays;

public class MoveAllZerosToEnd {
    public static void main(String[] args) {
        int[] myInput = {10,8,0,0,12,0};
        System.out.println(Arrays.toString(moveAllZerosToEnd(myInput)));
        int[] mySecondInput = {10,8,0,0,12,0};
        System.out.println(Arrays.toString(moveAllZerosToEnd(mySecondInput)));

    }
    public static int[] moveAllZerosToEnd(int[] input) {
        int pointerOne = 0;
        int pointerTwo = 1;
        int size = input.length;
        while (pointerTwo < size) {

            if (input[pointerOne] == 0 && input [pointerTwo] != 0) {
                input[pointerOne] = input[pointerTwo];
                input[pointerTwo] = 0;

            }
            if (input[pointerOne] != 0) {
                pointerOne += 1;
            }

            pointerTwo += 1;
        }

        return input;
    }

    public static int[] singleForLoopImplementation(int[] input) {
        int indexAtWhichThereIsPossibleZeroElement = 0;
        for (int i = 0; i < input.length; i +=1) {
            if (input[i] != 0) {
                int possibleZeroValue  = input[indexAtWhichThereIsPossibleZeroElement];
                int nonZeroValue = input[i];
                input[indexAtWhichThereIsPossibleZeroElement] = nonZeroValue;
                input[i] = possibleZeroValue;
                indexAtWhichThereIsPossibleZeroElement += 1;
            }
        }
        return input;
    }
}
