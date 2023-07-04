import java.util.Arrays;

public class Main {
    public static int DISTANCE = 100;
    public static int STEP = 1;

    public static void main(String[] args) {
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");
        Car carD = new Car("D");
        Car carE = new Car("E");

        Thread thread1 = new Thread(carA);
        Thread thread2 = new Thread(carB);
        Thread thread3 = new Thread(carC);
        Thread thread4 = new Thread(carD);
        Thread thread5 = new Thread(carE);

        System.out.println("Distance: 100KM");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
