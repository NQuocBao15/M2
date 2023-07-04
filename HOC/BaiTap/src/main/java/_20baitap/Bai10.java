package _20baitap;

import java.util.Arrays;

public class Bai10 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        addElement(arr, 8,2);
    }

    public static void addElement(int[] arr, int x, int k) {
        int[] arrNew = new int[arr.length + 1];
        for (int i = 0; i < k; i++) {
            arrNew[i] = arr[i];
        }
        arrNew[k] = x;
        for (int i = k + 1; i < arrNew.length; i++) {
            arrNew[i] = arr[i - 1];
        }
        System.out.println(Arrays.toString(arrNew));
    }
}
