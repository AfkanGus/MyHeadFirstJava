package com.taly.ThreadTestDrive;

/**
 * Created by Taly on 21.03.2018.
 */
 class MyRunnable implements Runnable{
    @Override
    public void run() {
        go();
    }
    private void go(){
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e){
            e.printStackTrace();
        }
        doMore();
    }
    private void doMore(){
        System.out.println("Вершина стека");
    }
}

public class ThreadTestDrive {
    public static void main(String[] args) {
        Runnable myRun = new MyRunnable();
        Thread thread = new Thread(myRun);
        thread.start();
        System.out.println("Метод main");
    }
}
