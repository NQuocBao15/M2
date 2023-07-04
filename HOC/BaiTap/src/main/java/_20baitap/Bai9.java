package _20baitap;

import java.util.*;

public class Bai9 {
    public static void main(String[] args) {
        int[] arr = {8, -5, 5, -3, 1, 9, 7, 6, 3, -2, 4};

        sortNumber(arr);
    }

    public static void sortNumber(int[] arr) {
        List<Integer> greaterNums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                greaterNums.add(arr[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                greaterNums.add(arr[i]);
            }
        }

        Collections.sort(greaterNums);

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 || arr[i] < 0) {
                arr[i] = greaterNums.get(j);
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
