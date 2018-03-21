package com.taly.RunThreads;

/**
 * Created by Taly on 21.03.2018.
 */
public class RunThreads implements Runnable {
    public static void main(String[] args) {
        Runnable job = new RunThreads();
        Thread threadA = new Thread(job);
        Thread threadB = new Thread(job);
        threadA.setName("Поток А");
        threadB.setName("Поток B");
        threadA.start();
        threadB.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            System.out.println("Выполняется поток " + Thread.currentThread().getName());
        }
    }
}
