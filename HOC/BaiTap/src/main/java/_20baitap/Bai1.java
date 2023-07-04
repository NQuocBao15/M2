package _20baitap;

public class Bai1 {
    // Bài 1: Hãy liệt kê các giá trị có toàn chữ số lẻ trong mảng 1 chiều các số nguyên
    public static void main(String[] args) {
        int[] arr = new int[10];

        listOddNum(arr);
    }

    public static int[] listOddNum(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                System.out.print(arr[i] + " ");
            }
        }
        return arr;
    }
}
