package _20baitap;

import java.util.ArrayList;
import java.util.List;

public class Bai14 {
    public static void main(String[] args) {
        // Xóa tất cả các phần tử trùng nhau trong mảng và chỉ giữ lại duy nhất 1 phần tử

        int[] a = {1,4,2,4,6,9,7};
        List<Integer> arrays = new ArrayList<>();

        int j = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == a[j]) {
                arrays.remove(a[i]);
                j++;
            }
        }
    }
}
