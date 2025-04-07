package hw4.deadLock;

import hw4.deadLock.bank.Account;
import hw4.deadLock.bank.BankTransaction;

public class BankTransactionSimulation {
    public static void main(String[] args) {
        Account account1 = new Account(1000);
        Account account2 = new Account(1000);

        Thread threadA = new Thread(() -> {
            System.out.println("Поток A: пытается перевести деньги со счета account1 на account2");
            BankTransaction.transfer(account1, account2, 500);
        }, "Thread-A");

        Thread threadB = new Thread(() -> {
            System.out.println("Поток B: пытается перевести деньги со счета account2 на account1");
            BankTransaction.transfer(account2, account1, 300);
        }, "Thread-B");

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Счет 1: " + account1.getBalance());
        System.out.println("Счет 2: " + account2.getBalance());
    }
}
