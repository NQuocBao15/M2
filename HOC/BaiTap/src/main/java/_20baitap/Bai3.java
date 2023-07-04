package _20baitap;

public class Bai3 {
    public static void main(String[] args) {
        int[] arr = {2,7,3,1,77,15,9,5,4,23,25};

        countEndingFive(arr);
    }

    public static void countEndingFive(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 10 == 5) {
                count++;
            }
        }
        System.out.println(count);
    }
}
