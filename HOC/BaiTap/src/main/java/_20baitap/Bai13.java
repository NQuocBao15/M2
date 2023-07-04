package _20baitap;

import java.util.Arrays;

public class Bai13 {
    public static void main(String[] args) {
        int[] a = {1, -2, 3, -4, 5};
        int[] b = removeEven(a);
        System.out.println(Arrays.toString(b));
    }

    public static int[] removeEven(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 != 0) {
                b[j] = a[i];
                j++;
            }
        }
        return Arrays.copyOf(b, j);
    }
}
