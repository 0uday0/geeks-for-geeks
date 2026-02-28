package Arrays;

public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] sampleArray = {1,2,4,3};
        System.out.println(isSorted(sampleArray));
    }
    public static boolean isSorted(int[] arr) {
        boolean result = true;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
