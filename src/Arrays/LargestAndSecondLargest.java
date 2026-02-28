package Arrays;

public class LargestAndSecondLargest {
    public static void main(String[] args) {
        int[] arr = {5,20,12,20,8};
        System.out.println(findLargest(arr));
        System.out.println(secondLargest(arr));

    }
    public static int findLargest(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i+=1) {
            if (arr[i]>max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static int secondLargest(int[] arr) {
        int largest;
        int secondLargest;
        if (arr[0] < arr[1]) {
            secondLargest = arr[0];
            largest = arr[1];
        } else {
            largest = arr[0];
            secondLargest=arr[1];
        }
        for (int i = 2; i< arr.length; i+=1) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;

    }
}
