import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 1, 6, 8, 4, 2, 7 };
        int n = arr.length;
        int[] aux = new int[n];
        for (int size = 1; size < n; size *= 2) {
            for (int left = 0; left < n - size; left += size * 2) {
                int right = Math.min(left + size * 2 - 1, n - 1);
                int mid = left + size - 1;
                merge(arr, aux, left, mid, right);
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(aux));
    }

    private static void merge(int[] arr, int[] aux, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            aux[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > right) {
                arr[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }
}
