package Arrays;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] myInput = {1,2,2,2,2,2};
        System.out.println(Arrays.toString(removeDuplicatesFromASortedArray(myInput)));
        int[] myNewInput = {1,2,2,2,2,2};
        System.out.println(Arrays.toString(standardMethod(myNewInput)));
    }

    public static int[ ] removeDuplicatesFromASortedArray(int[] myInput) {
        int pointerOne = 0;
        int pointerTwo = 1;
        int sizeOfTheArray = myInput.length;
        int totalUniqueItems = 0;
        while (pointerOne < sizeOfTheArray-1) {
            if (pointerTwo >= sizeOfTheArray) {
                pointerOne += 1;
                myInput[pointerOne] = 0;


            } else {
                if (myInput[pointerOne] == myInput[pointerTwo]) {
                    pointerTwo += 1;
                } else {
                    // There is a mismatch
                    totalUniqueItems += 1;
                    myInput[pointerOne + 1] = myInput[pointerTwo];
                    pointerOne+=1;
                    pointerTwo +=1;
                }
            }


        }
        System.out.println("These are the unique items "+(totalUniqueItems+1));
        return myInput;
    }

    public static int[] standardMethod(int[] myInput) {
        int result = 1;
        int size = myInput.length;
        for (int i = 1; i < size ; i +=1) {
            if (myInput[result -1] != myInput[i]) {
                myInput[result] = myInput[i];
                result +=1;
            }
        }
        System.out.println("The resultant number of unique items is "+result);
        return Arrays.copyOfRange(myInput,0,result);
    }
}
