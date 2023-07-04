package _20baitap;

public class Bai2 {
    public static void main(String[] args) {
        int[] arr = {2,7,3,1,77,15,9,5,4,23,25};

        findPrimes(arr);
    }

    public static void findPrimes(int[] arr) {         // BÀI 2
        System.out.print("vi tri cac so nguyen to trong mang la: ");
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                System.out.print(i+1 + " ");
            }
        }
    }    public static boolean isPrime(int n) {
        if (n <= 1) {return false;}
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {return false;}
        }
        return true;
    }
}
