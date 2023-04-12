package demo.multithreading;

public class WithdrawTask implements Runnable {
    private Account acct;
    public WithdrawTask(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        try {
            this.acct.withdraw(10);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
