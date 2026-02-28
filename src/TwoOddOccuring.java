import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoOddOccuring {
    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(1);
//        arr.add(2);
//        arr.add(2);
//        arr.add(3);
//        arr.add(3);
//        arr.add(4);
//        arr.add(5);
//        System.out.println(twoOddOccuring(arr));
        List<String> s = exhaustiveSubset("abc");
        System.out.println(s.toString());
    }
    public static List<Integer> twoOddOccuring(List<Integer> integerArray) {
        int result = integerArray.get(0);
        List<Integer> myFinalArray = new ArrayList<>();
        for (int  i = 1; i < integerArray.size(); i += 1) {
            result = result ^ integerArray.get(i);
        }
        int temp = result;
        System.out.println("My XOR result "+result);
        int positionOfBitToCheck = 1;
        while ((temp & 1)  == 0) {
            temp = temp >> 1;
            positionOfBitToCheck += 1;
        }
        int anotherCopy = result;
        for (int  j = 0; j< integerArray.size(); j+=1) {
            if (isKthBitSet(integerArray.get(j),positionOfBitToCheck)) {
                System.out.println("Kth bit set values are "+integerArray.get(j));
                anotherCopy = anotherCopy ^ integerArray.get(j);
            }
        }
        myFinalArray.add(anotherCopy);
        anotherCopy = result;
        System.out.println("My Another Copy is "+anotherCopy);
        for (int  k = 0; k< integerArray.size(); k+=1) {
            if (!isKthBitSet(integerArray.get(k),positionOfBitToCheck)) {
                System.out.println("K th bit not set values are "+integerArray.get(k));
                anotherCopy = anotherCopy ^ integerArray.get(k);
            }
        }
        myFinalArray.add(anotherCopy);
        return myFinalArray;
    }

    public static boolean isKthBitSet(int i,int k) {
        if ( (i & (int)Math.pow(2,k-1)) != 0) {
            return true;
        }
        return  false;
    }

    public static List<String> exhaustiveSubset(String str) {
        int lengthOfString = str.length();
        List<String> result = new ArrayList<>();
        Map<Integer,Character> lookup = new HashMap<>();
        for (int k = 0; k < lengthOfString; k += 1) {
            lookup.put(k,str.charAt(k));
        }
        for (int i = 0; i < Math.pow(2,lengthOfString); i += 1) {
            String binaryRep = Integer.toBinaryString(i);
            System.out.println("qwdwqdqwd");
            binaryRep = "0".repeat(lengthOfString-binaryRep.length())+binaryRep;
            System.out.println(binaryRep);
            String subsequence = "";
            for (int j = 0; j < lengthOfString ; j += 1) {
                if (binaryRep.charAt(j) == '1') {
                    System.out.println(lookup.get(j));
                    subsequence += lookup.get(j);
                }
            }
            result.add(subsequence);
        }
        return result;
    }
}
