import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class primeFactors {

    public static List<Integer> primeFactors(int givenInteger) {
        if (givenInteger <= 1) {
          return null;
        }

        List<Integer> result = new ArrayList<>();
        // One strategy is to find to loop till sqrt of num as done previously, if no factors are found then just return the [num] else
        if (givenInteger == 1) {
            return result;
        }

        if ( givenInteger == 2 || givenInteger == 3) {
            result .add(givenInteger);
            return result;
        }
        if (givenInteger % 2 == 0) {
            result.add(2);
            result.addAll(primeFactors(givenInteger / 2));
            return result;
        }
        if (givenInteger % 3 == 0) {
            result.add(3);
            result.addAll(primeFactors(givenInteger/3));
            return result;
        }

        for (int i = 5; i*i<=givenInteger; i+=6) {
            if (givenInteger % i == 0) {
                result.add(i);
                result.addAll(primeFactors(givenInteger/i));
                return result;
            }
            if (givenInteger % (i+2) == 0) {
                result.add(i+2);
                result.addAll(primeFactors(givenInteger/(i+2)));
                return result;
            }


        }
        result.add(givenInteger);
        return result;
    }

    public static List<Integer> fasterPrimeFactors(int givenInteger){
        List<Integer> result = new ArrayList<>();
        if (givenInteger <= 1) return null;

        for (int i = 1; i <= Math.sqrt(givenInteger); i+= 1) {
            if ((givenInteger % i == 0) && isAPrime(i)) {

                while (givenInteger % i == 0) {
                    result.add(i);
                    givenInteger = givenInteger /i;
                }
            }
        }
        if (givenInteger > 1) {
          result.add(givenInteger);
        }

        return result;
    }

    public static boolean isAPrime(int integer) {
        if (integer == 1) return false;
        if (integer == 2 || integer == 3) {
            return true;
        }
        if (integer % 2 == 0 || integer % 3 == 0) return false;
        for (int  i = 5; i*i <= integer; i+=6) {
            if (integer % i == 0|| integer %(i+2) == 0 ) {
               return false;
            }
        }
        return true;
    }

    public static List<Integer> primeFactorsWithoutCheckingForPrime(int givenInteger) {
        if (givenInteger <= 1) return null;
        List<Integer> result = new ArrayList<>();
        while(givenInteger % 2 == 0) {
            result.add(2);
            givenInteger = givenInteger /2;
        }
        while(givenInteger % 3 ==0) {
            result.add(3);
            givenInteger = givenInteger /3;
        }
        for (int i = 5; i*i <= givenInteger; i+=6) {
            while (givenInteger % i ==0) {
               result.add(i);
               givenInteger = givenInteger / i;
            }

            while (givenInteger % (i+2) == 0) {
                result.add(i+2);
                givenInteger = givenInteger / (i+2);
            }
        }
        if (givenInteger > 1) {
            result.add(givenInteger);
        }
        return result;


    }




}
