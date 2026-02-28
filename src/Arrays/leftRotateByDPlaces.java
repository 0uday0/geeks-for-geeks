package Arrays;

import java.util.Arrays;

public class leftRotateByDPlaces {
    public static void main(String[] args) {
        int[] myInput = {1,2,3,4,5};
        System.out.println(Arrays.toString(leftRotateByDPlacesCorrect(myInput,3)));
    }
        public static int[] leftRotateByDPlaces(int[] input, int d) {
            // Effectively it should move d %n spaces
            // If its 0 return array as is
            // if i - (d%n) < 0 it should go and sit in n-(d%n) position
            // else move that to i - (d%n) poistion.
            // what happens to the element that is currently at that position
            // This is not correct because if the input is even numbers of size and d is also even number then we're stuck in a loop
            int size  = input.length;
            int effectiveRotation = d > size ?  d % size : d;
            if (effectiveRotation == 0) {
                return  input;
            }
            int valueThatShouldBeShited = input[0];
            int indexOfTheValueThatShouldBeShifted = 0;
            for (int i = 0; i < size; i += 1) {
                System.out.println(valueThatShouldBeShited);
                System.out.println(indexOfTheValueThatShouldBeShifted);
                int finalPosition = indexOfTheValueThatShouldBeShifted - effectiveRotation;
                if (finalPosition < 0) {
                    finalPosition = size - Math.abs(finalPosition);
                }
                int temp = input[finalPosition];
                input[finalPosition] = valueThatShouldBeShited;
                valueThatShouldBeShited = temp;
                indexOfTheValueThatShouldBeShifted = finalPosition;
            }
            return  input;

        }

        public static int[] leftRotateByDPlacesCorrect(int[] input, int d) {
        // Lets say [1,2,3,4] Now lets say its d = 2 then the result is [3,4,1,2].
        // In a sense it is first d elements should come up at the last end
        int size = input.length;
        int effectiveRotation = d > size ? d %size : d;
        if (effectiveRotation == 0) {
            return input;
        }
        // The logic is lets say the first d elements are A and second size -d elements are B.
        // My original array is AB I need to make it as BA.
        // If  reverse(AB) = reverse(B)reverse(A)  then reverse(A)reverse(B) = reverse(BA);
        // reverse(reverse(BA)) = BA = reverse(reverse(A)reverse(B))

         // First reverse first d digits, the reverse remaining and then reverse whole thing
        reverseArray(input,0,d-1);
        reverseArray(input,d,size-1);
        reverseArray(input,0,size-1);
            System.out.println("The array to be printed is "+ Arrays.toString(input));
            return input;



        }
        public static void reverseArray(int[] arr, int startPosition, int endPosition) {
           int size = endPosition +1-startPosition;
           for (int i = startPosition; i < (startPosition + endPosition +1) / 2 ; i+=1) {
               int itemOnLeft = arr[i];
               int itemOnRight = arr[endPosition - i+startPosition];
               arr[i] = itemOnRight;
               arr[endPosition - i+startPosition] = itemOnLeft;
           }
            System.out.println("Reversed Elements between start And End Points "+Arrays.toString(arr));
        }


}
