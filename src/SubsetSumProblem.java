import java.util.Arrays;
import java.util.List;

public class SubsetSumProblem {
    public static void main(String[] args) {
        Integer[] input = {10,20,15};
        System.out.println(noOfSubsetsThatResultInAGivenSum(Arrays.asList(input),25));
        List<Integer>  sampleArray = Arrays.asList(input);
//        System.out.println(sampleArray.subList(7,8));
    }
    public static int noOfSubsetsThatResultInAGivenSum(List<Integer> input,int sum) {
        if (sum == 0) {

            return 1;
        }
        int result = 0;
        for (int i = 0; i < input.size(); i+=1) {
            System.out.println("My input "+input.toString()+ " "+sum);
            if (input.get(i) <= sum){
                System.out.println("Subset we're trying to "+input.subList(i+1,input.size()).toString() + " " +(sum-input.get(i)));
                int s= noOfSubsetsThatResultInAGivenSum(input.subList(i+1,input.size()),sum-input.get(i));
                result += s;
                System.out.println("whats my result for "+input.get(i)+" "+s);
            }
        }
        return result;

    }
    public static int noOfSubsetsThatResultInAGivenSum(List<Integer> input,int n,int sum) {
        if (n == 0) {

            return sum == 0?1:0;
        }
        return noOfSubsetsThatResultInAGivenSum(input,n-1,sum)+noOfSubsetsThatResultInAGivenSum(input,n,sum-input.get(n-1));

    }
}
