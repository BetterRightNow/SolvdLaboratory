import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // create an unsorted integer array
        int[] arr = { 5, 3, 1, 6, 8, 4, 2, 7 };
        // get the length of the array
        int n = arr.length;
        // create a new array for temporary storage during sorting
        int[] aux = new int[n];
        // perform the merge sort algorithm on the input array
        for (int size = 1; size < n; size *= 2) {
            for (int left = 0; left < n - size; left += size * 2) {
                // calculate the indices for the current subarrays
                int right = Math.min(left + size * 2 - 1, n - 1);
                int mid = left + size - 1;
                // merge the current subarrays
                merge(arr, aux, left, mid, right);
            }
        }
        // print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    // merge two sorted subarrays
    private static void merge(int[] arr, int[] aux, int left, int mid, int right) {
        // copy the subarrays into the auxiliary array
        for (int i = left; i <= right; i++) {
            aux[i] = arr[i];
        }
        // initialize variables for the start of each subarray
        int i = left;
        int j = mid + 1;
        // merge the subarrays into the original array
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                // if the left subarray has been fully merged, take elements from the right subarray
                arr[k] = aux[j++];
            } else if (j > right) {
                // if the right subarray has been fully merged, take elements from the left subarray
                arr[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                // if the next element in the left subarray is smaller, take it
                arr[k] = aux[i++];
            } else {
                // if the next element in the right subarray is smaller, take it
                arr[k] = aux[j++];
            }
        }
    }
}
