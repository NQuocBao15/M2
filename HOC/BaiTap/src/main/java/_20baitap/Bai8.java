package _20baitap;

import java.util.*;

public class Bai8 {
    public static void main(String[] args) {
        int[] arr = {2, 99, 7, 4, 3, 1, 6, 12, 23, 9, 5, 4, 13, 5};

        sortOddNumbers(arr);
    }

    public static void sortOddNumbers(int[] arr) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                oddNumbers.add(arr[i]);
            }
        }
        Collections.sort(oddNumbers);

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                arr[i] = oddNumbers.get(j);
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
