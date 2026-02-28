package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leadersInAnArray {
    public static void main(String[] args) {
        int[] input = {10, 4, 2, 4, 1};
        System.out.println(leadersInAnArray(input).toString());
        System.out.println(muchCleanerSolutionToLeadersInArray(input).toString());
    }

    public static List<Integer> leadersInAnArray(int[] input) {
        ArrayList<Integer> leaders = new ArrayList<>();
        for (int  i = 0; i < input.length; i += 1) {
            int leadersSize = leaders.size();
            if (leadersSize == 0) {
                leaders.add(input[i]);
            } else {
                int lastAddedLeader = leaders.get(leadersSize -1);
                if (lastAddedLeader < input[i]) {
                    while ( leaders.size() > 0 && leaders.get(leaders.size()-1) <= input[i]) {
                        leaders.remove(leaders.size() -1);
                    }
                    leaders.add(input[i]);
                } else {
                    leaders.add(input[i]);
                }
            }
        }
        return leaders;
    }

    public static List<Integer> muchCleanerSolutionToLeadersInArray(int[] input) {
        int size = input.length;
        ArrayList<Integer> arr  = new ArrayList<>();
        int currentMax = input[size-1];
        arr.add(currentMax);
        for (int i = size - 2; i >= 0; i -= 1 ) {
            if (input[i] > currentMax) {
                arr.add(input[i]);
                currentMax = input[i];
            }
        }
         Collections.reverse(arr);
        return arr;
    }
}
