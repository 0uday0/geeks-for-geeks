package Arrays;

import java.util.Arrays;

public class Deletion {
    public static void main(String[] args) {
        int[] sampleArr = {11,12,12,12,3};
        System.out.println(Arrays.toString(deletion(sampleArr,5,12)));
    }

    public static int[] deletion(int[] arr,int size,int elemnentToDelete) {
        int positionOfElementToBeDeleted = -1;
        int pointer =0;
        while (positionOfElementToBeDeleted < size ) {
            if (pointer >= size) {
                if (positionOfElementToBeDeleted > -1) {
                    arr[positionOfElementToBeDeleted] = 0;
                    positionOfElementToBeDeleted += 1;
                } else {
                    break;
                }
            } else {
                if (arr[pointer] == elemnentToDelete && positionOfElementToBeDeleted > -1) {

                } else if (arr[pointer] == elemnentToDelete && positionOfElementToBeDeleted == -1) {
                    positionOfElementToBeDeleted = pointer;

                } else if (arr[pointer] != elemnentToDelete && positionOfElementToBeDeleted > -1) {
                    arr[positionOfElementToBeDeleted] = arr[pointer];
                    positionOfElementToBeDeleted += 1;
                }
                pointer += 1;
            }


        }
        return arr;
    }
}
