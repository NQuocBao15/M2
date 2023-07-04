package _20baitap;

import java.util.Arrays;

public class Bai11 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int x = 8;

        int viTriChen = 3;
        for (int i = 0; i < arr.length; i++) {
            if (x > arr[i]) {
                viTriChen = i + 1;
            } else {
                break;
            }
        }

        for (int i = arr.length - 1; i >= viTriChen; i--) {
            arr[i + 1] = arr[i];
        }

        arr[viTriChen] = x;

        System.out.println(Arrays.toString(arr));
    }
}
