package _20baitap;

public class Bai5 {
    public static void main(String[] args) {
        int[] arr = {2,7,3,1,77,15,9,5,4,23,25};
        int[] arr2 = {9,8,7,6,5,4,3,2,1};

        System.out.println(checkArray(arr));
        System.out.println(checkArray(arr2));
    }

    public static boolean checkArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
