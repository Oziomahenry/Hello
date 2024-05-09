import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // No need to sort
        }

        // Find the maximum value in the array to determine the range
        int max = Arrays.stream(arr).max().getAsInt();

        // Create a count array to store the frequency of each element
        int[] count = new int[max + 1];

        // Count the occurrences of each element in the input array
        for (int num : arr) {
            count[num]++;
        }

        // Update the count array to store the cumulative count of elements
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Create a temporary array to hold the sorted elements
        int[] temp = new int[arr.length];

        // Build the sorted array using the count array
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            temp[count[num] - 1] = num;
            count[num]--;
        }

        // Copy the sorted elements back to the original array
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 8, 3, 3, 1 };
        System.out.println("Original array: " + Arrays.toString(arr));

        countingSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
