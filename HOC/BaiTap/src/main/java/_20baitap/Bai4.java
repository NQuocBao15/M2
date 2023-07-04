package _20baitap;

public class Bai4 {
    public static void main(String[] args) {
        int[] arr = {2,7,3,1,77,15,9,5,4,23,25};

        System.out.println(findZero(arr));
    }

    public static int findZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return 1;
            }
        }
        return 0;
    }
}
