package Arrays;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] input = {1,10,5};
        System.out.println(doesSuchASubArrayExists(input,15));
        System.out.println(moreEfficientImplementation(input,15));
        System.out.println(forLoopImplementation(input,15));
    }
    public static boolean doesSuchASubArrayExists(int[] input,int sum) {
        int size = input.length;
        if (size == 1) {
            return input[0] == sum;
        }
        for (int i =1; i < size; i+=1) {
            int f = SumOfKElementsMatchingASum(input,i,sum);
            System.out.println("My f "+f);
            if (f == sum) {
                return true;
            } else if (f > sum) {
                return false;
            }
        }
        return false;
    }

    public static int SumOfKElementsMatchingASum(int[] input,int k,int sum) {
        double minimumSumInThisArray = Double.NEGATIVE_INFINITY;
        int result = 0;
        for (int i = 0; i < k; i +=1) {
            result +=input[i];
        }
        if (result == sum) {
            return result;
        }
        minimumSumInThisArray = result;
        int j = k;
        while ( j < input.length) {
            result = result + input[j] - input[j-k];
            if (result == sum) {
               return  result;
            } else {
                minimumSumInThisArray = Math.min(minimumSumInThisArray,result);
            }
            j+=1;
        }
        return (int) minimumSumInThisArray;

    }

    public static boolean moreEfficientImplementation(int[] input, int sum) {
        int size = input.length;
        int startIndex = 0;
        int endIndex = 0;
        int sumOfSubArray = input[startIndex];
        // Edge case
           // i. If the  sum is greater than sum of all elements
           // ii.
        while (startIndex < size && endIndex < size) {
            if (endIndex == size -1 && sumOfSubArray < sum) {
                return false;
            }
            if(startIndex == size -1 && sumOfSubArray > sum) {
                return false;
            }

            if (sumOfSubArray < sum) {
                endIndex+=1;
                sumOfSubArray += input[endIndex];
            } else if (sumOfSubArray == sum) {
                return true;
            } else {
                sumOfSubArray = sumOfSubArray - input[startIndex];
                startIndex +=1;

            }
        }
        return false;

    }

    public static boolean forLoopImplementation(int[] input,int sum) {
        int startIndex = 0;
        int size = input.length;
        int currentSum = 0;
        for (int endIndex = 0; endIndex < size; endIndex+=1) {
            // 1. Add the next element
            currentSum += input[endIndex];

            // 2. While the sum is too big, shrink from the left
            // This replaces your 'else' block logic
            while (currentSum > sum && startIndex <= endIndex) {
                currentSum -= input[startIndex];
                startIndex++;
            }
            if (currentSum == sum) {
                return true;
            }

        }
        return false;
    }

    

}
