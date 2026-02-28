package Arrays;

import java.util.HashMap;
import java.util.Map;

public class FrequenciesOfASortedArray {
    public static void main(String[] args) {
        int[] input = {};
        System.out.println(frequencies(input).toString());
        frequenciesBetterWay(input);
    }
    public static Map<Integer,Integer> frequencies(int[] input) {
        int size = input.length;
        Map<Integer,Integer> result = new HashMap<>();
        for(int i = 0; i < size; i+=1) {
            if (result.containsKey(input[i])) {
                result.put(input[i],result.get(input[i])+1 );
            } else {
                result.put(input[i],1);
            }
        }
        return  result;
    }

    public static  void frequenciesBetterWay(int[] input) {
        int size = input.length;
        int frequencies = 1;
        for ( int i = 1; i < size; i +=1){
            if (input[i] != input[i-1]) {
                System.out.println("Frequency of "+input[i-1]+" is "+frequencies);
                frequencies = 1;
            } else {
                frequencies += 1;
            }
        }
        System.out.println("Frequency of "+input[size-1]+" is "+frequencies);

    }
}
