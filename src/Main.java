import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (scanner.hasNext()) {
//            Integer givenInteger = scanner.nextInt();
////            System.out.println(primeFactors.primeFactors(givenInteger).toString());
//            System.out.println(primeFactors.fasterPrimeFactors(givenInteger).toString());
//        }
//        stressTestTheSolution();
//        stressTestDivisors();
//         stressTestThePrimeNumbers();
//        primesLessThanANumber.sieveOfErastothenes(100);
//        power.computePower(2,10);
//        stressTestComputePower();
//        System.out.println(power.computePowerEfficient(2,-2));
//        System.out.println(spaceEfficientSolutionForPower(2,5));
//        primesLessThanANumber.exactly3Divisors(999999);
//        System.out.println("My divisor is "+2%15);
//        System.out.println("And operation result "+BitwiseOperators.andOperation(5,4));
//        System.out.println("Or operation result "+BitwiseOperators.orOperation(5,4));
//        System.out.println("XOR operation result "+BitwiseOperators.xorOperation(5,4));
//        System.out.println("Negate Operator result "+BitwiseOperators.notOperator(1));
//        System.out.println("Left shit operator result "+BitwiseOperators.leftShiftOperator(3,2));
//        System.out.println("Signed Right shift operator result "+BitwiseOperators.signedRightShiftOperator(-1,2));
//        System.out.println("Unsigned Right shift operator result "+BitwiseOperators.unsignedRightShiftOperator(-1,2));
//        System.out.println("Find the binary Representation of a number "+BitwiseOperators.findBinaryRepresentationOfANumber(15));
//        System.out.println("The binary representation of a negative number in 2 negative complement "+BitwiseOperators.findBinaryRepresentationOfANumber(-16) );
//        System.out.println("The K th bit is  "+BitwiseOperators.isKBitSet(5,1));
//        System.out.println("The  Kth bit is correct "+BitwiseOperators.isKBitSetCorrectImplementation(5,1));
//        System.out.println("Total number of bits "+BitwiseOperators.numberOfBitsSet(13));
//        stressTestEfficientApproach();
        System.out.println("Is a power of two "+BitwiseOperators.powerOfTwo(0));
    }

    public static void stressTestTheSolution () {
        while (true) {
            Random random = new Random();
            int testCase = random.nextInt();
            if (testCase > 0) {
                System.out.printf("The Test Case %d%n",testCase);

                List<Integer> myImplmentation = primeFactors.primeFactors(testCase);
                List<Integer> gfgImplementation = primeFactors.fasterPrimeFactors(testCase);
                List<Integer> wayMoreFasterApproach = primeFactors.primeFactorsWithoutCheckingForPrime(testCase);
                System.out.printf("My Implementation %s %n",myImplmentation.toString());
                System.out.printf("GFG Implementation %s %n",gfgImplementation.toString());
                System.out.printf("Faster Implmentation %s %n",wayMoreFasterApproach.toString());
                if (!myImplmentation.equals(gfgImplementation) || !gfgImplementation.equals(wayMoreFasterApproach)) {
                    break;
                }
            }
        }
    }

    public static void stressTestDivisors() {

        while (true) {
            Random random = new Random();
            int testCase = random.nextInt();
            if (testCase > 0) {

                System.out.printf("The Given Integer %s %n",testCase);
                List<Integer> result = divisors.divisorList(testCase);
                System.out.printf("The result of fetching Divisors %s %n",result.toString());
            }
        }

    }

    public static void stressTestThePrimeNumbers () {
        while(true) {
            Random random = new Random();
            Integer test = random.nextInt();
            if (test > 0 ) {
                System.out.printf("THis is getting executed %s ",test);
                List<Integer> result = primesLessThanANumber.primesLessThanANumber(test);
                System.out.printf("The list of prime Numbers less than %s %s %n",test,result.toString());
            }

        }
    }

    public static int spaceEfficientSolutionForPower(int givenInteger,int power){
        String binaryRepresentationOfPower = "";
        int temp = power;
        int result = 1;
        while (temp != 0) {
            if (temp % 2 == 0) {
                binaryRepresentationOfPower = "0"+binaryRepresentationOfPower;
            } else {
                binaryRepresentationOfPower = "1"+binaryRepresentationOfPower;
                result = result *givenInteger;
            }
            givenInteger *= givenInteger;
            temp = temp / 2;
        }
        System.out.println("My Final Binary representation "+binaryRepresentationOfPower);
        return result;

    }
    public static void  stressTestEfficientApproach() {
        Random random = new Random();
        int randomInteger = random.nextInt();
        while(BitwiseOperators.numberOfBitsSet(randomInteger) == BitwiseOperators.moreEfficientApproach(randomInteger)) {
            System.out.println("Both Implementations produced same output "+randomInteger);
        }
        System.out.println("Both Implementations yielded different results "+randomInteger);
        System.out.println("Implementation one "+BitwiseOperators.numberOfBitsSet(randomInteger) );
        System.out.println("Implementation one "+BitwiseOperators.moreEfficientApproach(randomInteger) );


    }

//    public static void stressTestComputePower() {
//        while(true) {
//            Random random = new Random();
//            int base = random.nextInt();
//            int exponent = random.nextInt(100);
//            int myResult= power.computePower(base,exponent);
//            int gfgResult = power.computePowerEfficient(base,exponent);
//
//            if (myResult != gfgResult) {
//                System.out.printf("Result does not match My Result:%s GFG Result:%s",myResult,gfgResult);
//                break;
//            } else {
//                System.out.printf("For given base %s and power %s, My Result %s and GFG Result %s matches",base,exponent,myResult,gfgResult);
//            }
//        }
//    }
}