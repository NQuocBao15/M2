package _20baitap;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 1, 77, 15, 9, 5, 4, 23, 25};
        int[] arr3 = {2,7,3,1};

        System.out.println(findAInB(arr3,arr));
    }

    public static boolean findAInB(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            boolean found = false;
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
