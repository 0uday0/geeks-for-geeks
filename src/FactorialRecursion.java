import java.util.HashMap;
import java.util.Map;

public class FactorialRecursion {
    private static Map<Integer,Integer> frequency = new HashMap<>();
    public static void main(String[] args) {
//        System.out.println(factorialWrapper(2));
//        for (int i = 1; i <= 10 ; i+=1) {
//            System.out.println(nthFib(i));
//            System.out.println(sumOfNNaturalNumbers(i));
//        }
//        System.out.println(palindromeRecursionFlavour("arbra"));
//        System.out.println(palindromeRecursionElegant("aba",0,2));
//        System.out.println(sumOfDigitsInRecursive(9987));
//        System.out.println(sumOfDigitsIterative(9987));
//        System.out.println(ropeCuttingProblem(23,12,9,11));
        System.out.println(ropeCuttingProblemRefactored(9,2,2,2,frequency));

    }
    public static int factorialWrapper(int m) {
        if (m == 0) {
            return 1;
        }
        return factorial(m,m-1);
    }
    public static int factorial(int m,int k) {
        if (k == 0 || k == 1) {
            return m;
        }
        return factorial(m*k,k-1);
    }
    public static int nthFib(int m) {
        // If it starts from 1
        if (m < 3) {
            return m-1;
        }
        return nthFib(m-1)+nthFib(m-2);
    }
    public static int sumOfNNaturalNumbers(int h) {
        if (h == 0) {

            return 0;
        }
        return h + sumOfNNaturalNumbers(h-1);

    }
    public static boolean palindromeRecursionFlavour(String sample) {

        int  n = sample.length();
        if (n==0 || n == 1 )  {
            return true;
        }
        if (sample.charAt(0) == sample.charAt(n-1)) {
            return palindromeRecursionFlavour(sample.substring(1,n-1));
        } else {
            return false;
        }

    }

    public static boolean palindromeRecursionElegant(String sampleString,int start,int end) {
        if (start >= end) {
            return true;
        }
        if (sampleString.charAt(start) == sampleString.charAt(end)) {
            return palindromeRecursionElegant(sampleString,start+1,end-1);

        } else {
            return false;
        }
    }

    public static int sumOfDigitsInRecursive(int givenNumber) {
        if (givenNumber < 10) {
            return givenNumber;
        }
        return (givenNumber % 10) + sumOfDigitsInRecursive(givenNumber /10);
    }

    public static int sumOfDigitsIterative(int givenNumber) {
        int result = 0;
        while (givenNumber != 0) {
            result += givenNumber %10;
            givenNumber  = givenNumber /10;
        }

        return result;
    }
   // Implementing memoization as well;

    public static int ropeCuttingProblemRefactored (int lengthOfRope,int a,int b, int c,Map<Integer,Integer> map) {
        if (lengthOfRope == 0) {
            return 0;
        }
        if (lengthOfRope < 0) {
            return -1;
        }
        if (map.get(lengthOfRope) != null) {
            return map.get(lengthOfRope);
        }
        int noOfPartsIfWeCutOfSizeA = ropeCuttingProblemRefactored(lengthOfRope-a,a,b,c,map);
        int noOfPartsIfWeCutOfSizeB =ropeCuttingProblemRefactored(lengthOfRope-b,a,b,c,map);
        int noOfPartsIfWeCutOfSizeC  = ropeCuttingProblemRefactored(lengthOfRope-c,a,b,c,map);
        if (noOfPartsIfWeCutOfSizeA >= 0) {
            noOfPartsIfWeCutOfSizeA += 1;
        }
        if (noOfPartsIfWeCutOfSizeB >= 0) {
            noOfPartsIfWeCutOfSizeB += 1;
        }
        if(noOfPartsIfWeCutOfSizeC >= 0) {
            noOfPartsIfWeCutOfSizeC +=1;
        }
        int result = Math.max(Math.max(noOfPartsIfWeCutOfSizeA,noOfPartsIfWeCutOfSizeB),noOfPartsIfWeCutOfSizeC);
        map.put(lengthOfRope,result);
        return result;
    }

    public static int ropeCuttingProblem(int lengthOfRope,int a,int b, int c) {
        if (lengthOfRope == 0) {
            return 0;
        }
        if (lengthOfRope < Math.min(Math.min(a,b),c)) {
            return -1;
        }

        if (lengthOfRope == Math.min(Math.min(a,b),c)) {
            return 1;
        }
        int firstPossibility = 0;
        int secondPossibility = 0;
        int thirdPossibility = 0;
        if (lengthOfRope >= a) {
            int subResult = ropeCuttingProblem(lengthOfRope-a,a,b,c);
            if (subResult == -1) {
                firstPossibility = -1;
            }else {
                firstPossibility = 1+subResult;
            }

        }
        if (lengthOfRope >= b) {
            int subResult = ropeCuttingProblem(lengthOfRope-b,a,b,c);
            if (subResult == -1) {
                secondPossibility = -1;
            } else {
                secondPossibility = 1 +subResult;
            }

        }
        if (lengthOfRope >= c) {
           int subResult = ropeCuttingProblem(lengthOfRope-c,a,b,c);
           if (subResult == -1) {
               thirdPossibility = -1;
           }else {
               thirdPossibility = 1 + subResult;
           }
        }
        int result = Math.max(Math.max(firstPossibility,secondPossibility),thirdPossibility);
        if (result == 0) {
            return -1;
        }
        return result;

    }

}
