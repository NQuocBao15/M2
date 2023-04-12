package demo.multithreading;

public class WithdrawTest {
    public static void main(String[] args) {
        Account a = new Account("A", 15);

        Runnable task1 = new WithdrawTask(a);
        Thread t1 = new Thread(task1);
        Runnable task2 = new WithdrawTask(a);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}
