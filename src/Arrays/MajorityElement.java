package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] input = {8,3,4,8,8};
        System.out.println(majorityElement(input));
    }

    public static int majorityElement(int[] input) {
        int result = -1;
        // Majority Element is that element whose occurence is greater than or equal to Math.floor(n/2)+1;
        Map<Integer,Integer> frequency = new HashMap<>();
        int size = input.length;
        for (int i = 0; i<input.length; i+=1) {
            int elem = input[i];
            if (frequency.containsKey(elem)) {
                int updatedFrequency = frequency.get(elem)+1;
                frequency.put(elem,updatedFrequency);
                if (((size/2)+1) >= updatedFrequency) {
                    return i;
                }

            } else {
                frequency.put(elem,1);
            }
        }
        return result;

    }
}
