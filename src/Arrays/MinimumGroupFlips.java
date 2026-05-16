package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MinimumGroupFlips {
    public static void main(String[] args) {
        int[] input = {1, 0, 0, 1, 0};
//        printTheMinFlips(myInput);
        withOneTraversal(input);
    }
    public static void printTheMinFlips(int[] input) {
        List<Integer> integers = new ArrayList<>();
        integers.add(input[0]);
        for (int index = 1 ; index < input.length; index +=1) {
            if (input[index] != input[index-1]) {
                integers.add(index);
            }
        }
        int totalInflections = integers.size();
        if (totalInflections == 1) {
            System.out.println("All the elements are same");
        }
        for (int j = 0; j < integers.size(); j +=1) {
            if (j%2 ==1 && j != totalInflections -1) {
                System.out.println("From "+integers.get(j)+" to "+(integers.get(j+1)-1));
            } else if (j % 2 == 1 && j == totalInflections-1) {
                System.out.println("From "+integers.get(j)+" to "+(totalInflections-1));
            }
        }

    }

    public static void withOneTraversal(int[] input) {
        int firstElementOfInput = input[0];
        int startingIndexOfDifferentGroup = -1;
        int finalIndexOfDifferentGroup = -1;
        for (int i = 1; i < input.length; i +=1) {
            if (input[i] != firstElementOfInput) {
                if (startingIndexOfDifferentGroup == -1) {
                    startingIndexOfDifferentGroup = i;
                }
                finalIndexOfDifferentGroup = i;
            } else if (input[i] == firstElementOfInput) {
                if (startingIndexOfDifferentGroup != -1) {
                    System.out.println("From "+startingIndexOfDifferentGroup+" to "+finalIndexOfDifferentGroup);
                    startingIndexOfDifferentGroup = -1;
                    finalIndexOfDifferentGroup = -1;
                }
            }
        }
        if ( startingIndexOfDifferentGroup != -1) {
            System.out.println("From "+startingIndexOfDifferentGroup+" to "+finalIndexOfDifferentGroup);

        } else if (startingIndexOfDifferentGroup == -1) {
            System.out.println("All the elements are same");
        }

    }
}
