package _20baitap;

import java.util.Arrays;

public class Bai12 {
    public static void main(String[] args) {
        int[] a = {1, -2, 3, -4, 5};
        int[] b = removeNegative(a);
        System.out.println(Arrays.toString(b));
    }

    public static int[] removeNegative(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= 0) {
                b[j] = a[i];
                j++;
            }
        }
        int[] result = Arrays.copyOf(b, j);
        return result;
    }
}
