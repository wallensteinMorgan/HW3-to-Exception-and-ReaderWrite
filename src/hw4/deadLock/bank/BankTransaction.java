package hw4.deadLock.bank;

public class BankTransaction {
    public static void transfer(Account from, Account to, double amount) {
        synchronized (from) {
            System.out.println(Thread.currentThread().getName() + ": заблокировал счет отправителя");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (to) {
                System.out.println(Thread.currentThread().getName() + ": заблокировал счет получателя");
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println(Thread.currentThread().getName() + ": перевод выполнен");
            }
        }
    }
}
