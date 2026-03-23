package Arrays;

public class longestEvenOdd {
    public static void main(String[] args) {
        int[] input = {5, 10, 20,6,3,8};
        System.out.println("My Array Length "+findLength(input));
        System.out.println("My Clean solution "+ cleanSolution(input));
    }
    public static int findLength(int[] input) {
        int maxSublength = 1;
        int length = 1;
        String lastSeen = (input[0] % 2 == 0) ? "even" : "odd";
        for (int i =1; i<input.length; i +=1) {
            if (input[i] % 2 == 0 && lastSeen.equalsIgnoreCase("odd")) {
                length+=1;

            } else if (input[i] % 2 != 0 && lastSeen.equalsIgnoreCase("even") ) {
                length+=1;

            } else {
                if (length > maxSublength) {
                    maxSublength = length;
                }
                length = 1;

            }
            lastSeen = (input[i] % 2 == 0) ? "even" : "odd";
        }

        return Math.max(maxSublength,length);
    }

    public static int cleanSolution(int[] input) {
        int result = 1;
        int curr = 1;
        for (int i  =1; i < input.length; i+=1) {
            if (input[i] %2 != input[i-1]%2) {
                curr += 1;
                result = Math.max(curr,result);
            } else {
                curr = 1;
            }
        }
        return result;
    }
}
