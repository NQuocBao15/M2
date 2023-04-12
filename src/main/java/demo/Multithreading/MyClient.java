package demo.Multithreading;

public class MyClient {
    public static void main(String[] args) {
//        Runnable task1 = new MyTask(50, "A");
        Thread t1 = new MyTask(50, "A");                // new Thread(task1);
//        Runnable task2 = new MyTask(50, "B");
        Thread t2 = new MyTask(50, "B");                // new Thread(task2);

        t1.start();
        t2.start();
    }
}
