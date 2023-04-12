package demo.Multithreading;

public class Account {
    private String name;
    private double amount;

    public Account(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public synchronized void withdraw (double a) throws InterruptedException {
        if (this.getAmount() >= a) {
//            Thread.sleep(1000);
            this.setAmount(this.getAmount() - a);
            System.out.println(this.getAmount());
        } else {
            System.err.println("NOT ENOUGH MONEY");
        }
    }
}
