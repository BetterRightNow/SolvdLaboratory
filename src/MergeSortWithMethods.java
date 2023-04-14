import java.util.Arrays;

public class MergeSortWithMethods {

        public static void main(String[] args) {
            int[] arr = { 5, 3, 1, 6, 8, 4, 2, 7 };

            // Print unsorted array
            System.out.println("Unsorted array: " + Arrays.toString(arr));

            // Sort the array using merge sort
            mergeSort(arr, 0, arr.length-1);

            // Print sorted array
            System.out.println("Sorted array: " + Arrays.toString(arr));
        }

        // Recursive method to sort the array using merge sort
        private static void mergeSort(int[] arr, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(arr, left, mid); // Sort left subarray
                mergeSort(arr, mid+1, right); // Sort right subarray
                merge(arr, left, mid, right); // Merge sorted subarrays
            }
        }

        // Merge two sorted subarrays into a single sorted array
        private static void merge(int[] arr, int left, int mid, int right) {
            // Create temporary arrays for left and right subarrays
            int[] leftArr = new int[mid - left + 1];
            int[] rightArr = new int[right - mid];

            // Copy data from original array into temporary arrays
            for (int i = 0; i < leftArr.length; ++i) {
                leftArr[i] = arr[left + i];
            }
            for (int j = 0; j < rightArr.length; ++j) {
                rightArr[j] = arr[mid + 1 + j];
            }

            // Merge the two temporary arrays back into the original array
            int i = 0, j = 0, k = left;
            while (i < leftArr.length && j < rightArr.length) {
                if (leftArr[i] <= rightArr[j]) {
                    arr[k++] = leftArr[i++];
                } else {
                    arr[k++] = rightArr[j++];
                }
            }

            // Copy any remaining elements from left or right subarrays
            while (i < leftArr.length) {
                arr[k++] = leftArr[i++];
            }
            while (j < rightArr.length) {
                arr[k++] = rightArr[j++];
            }
        }
}
