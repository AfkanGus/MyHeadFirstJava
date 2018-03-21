package com.taly.BankAccount;

/**
 * Created by Taly on 21.03.2018.
 */
class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }
}

public class RaynAndMonicaJob implements Runnable{
    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        Runnable job = new RaynAndMonicaJob();
        Thread jobRayn = new Thread(job);
        Thread jobMonica = new Thread(job);
        jobRayn.setName("Rayn");
        jobMonica.setName("Monica");
        jobRayn.start();
        jobMonica.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Превышение лимита!");
            }
        }
    }

    private void makeWithdrawal(int amount){
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " собирается снять деньги");
            try {
                System.out.println(Thread.currentThread().getName() + " идет подремать");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " просыпается");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " заканчивает транзакцию");

        } else {
            System.out.println("Извините, для клиента " + Thread.currentThread().getName() + " недостаточно денег");
        }
    }
}
