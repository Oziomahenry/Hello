import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: already sorted or empty
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotIndex = getPivotIndex(arr, low, high);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high); // Move pivot to the end
        int i = low; // Index to track smaller elements

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high); // Move pivot back to its correct position
        return i;
    }

    private static int getPivotIndex(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2; // Calculate mid index
        int a = arr[low];
        int b = arr[mid];
        int c = arr[high];

        // Determine median index
        if ((a <= b && b <= c) || (c <= b && b <= a)) {
            return mid;
        } else if ((b <= a && a <= c) || (c <= a && a <= b)) {
            return low;
        } else {
            return high;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 1, 2, 9, 4, 7, 6 };
        System.out.println("Original array: " + Arrays.toString(arr));

        quickSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
