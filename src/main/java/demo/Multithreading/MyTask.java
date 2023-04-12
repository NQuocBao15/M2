package demo.Multithreading;

public class MyTask extends Thread {
    private int times;
    private String name;

    public MyTask(int times, String name) {
        this.times = times;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < this.times; i++) {
                System.out.print(this.name);
                if (i == 20) {
                    currentThread().join();
                }
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

    }
}
