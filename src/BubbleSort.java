import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("PLease insert 10 numbers to sort");
        Scanner scan = new Scanner(System.in);
        int sort[] = new int[10];
        for (int i = 0; i < 10; i++) {
            sort[i] = scan.nextInt();
        }

        for (int x = 0; x < 9; x++) {
            for (int j = 0; j < 9 - x; j++) {
                if (sort[j] > sort[j + 1]) {
                    int temp = sort[j];
                    sort [j] = sort[j+1];
                    sort[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(sort));
    }

}
