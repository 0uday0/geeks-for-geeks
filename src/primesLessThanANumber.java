import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class primesLessThanANumber {

    public static List<Integer> primesLessThanANumber(int givenInteger) {
        List<Integer> result = new ArrayList<>();
        for (int i =2; i<= givenInteger; i+=1) {
            if (primeFactors.isAPrime(i)) {
                System.out.printf("Collecting primes %s",i);
                result.add(i);
            }
        }
        return result;
    }
    public static int exactly3Divisors(int n) {
        // code here
        int noOfItemsNeedToCheck = (int) (Math.floor(Math.sqrt(n))+1);
        int[] result = new int[noOfItemsNeedToCheck];
        System.out.println("No of Items to check "+noOfItemsNeedToCheck);
        System.out.println("The Instantiated result is "+ Arrays.toString(result));
        for (int i  =2; i*i<noOfItemsNeedToCheck; i+=1) {

            int position = i;
            int temp = i*2;
            System.out.println("The position we're starting with "+position);
            int num = 2;
            if (position*num < noOfItemsNeedToCheck && result[position] != 1) {
                while ((position*num ) < noOfItemsNeedToCheck) {

                    result[position * num] = 1;
                    num += 1;
                    temp += i;
//                    System.out.println("How does the both vary "+pos);
                }
                System.out.println("Final multiple of the position after the while loop "+position*num);
            }


        }
        System.out.println("The final Result of primes is "+Arrays.toString(result));
        int totalPrimes = 0;
        for (int j = 2; j < noOfItemsNeedToCheck; j+=1) {
            if (result[j] == 0) {
                totalPrimes += 1;
            }
        }
        System.out.println("Total primes are "+totalPrimes);
        return totalPrimes;
    }

    public static List<Integer> sieveOfErastothenes(int givenInteger) {
        int[] result = new int[givenInteger];
        List<Integer> actualResult = new ArrayList<>();
        for (int i = 2; i*i < givenInteger; i+=1) {
            if (i != 1) {
                int num = 2;
                while ((i * num)+1 < givenInteger) {
                    result[(i*num)+1] = 1;
                    num += 1;
                }
            }
        }
        for (int i = 2; i+1 < givenInteger; i+=1) {
            if (result[i+1] != 1) {
                actualResult.add(i);
            }
        }
        System.out.println("THis is the is prime modified "+result.toString());
        System.out.println("This is the actual List "+actualResult.toString());

        return actualResult;


    }
}
