package com.kharkhanov;

public class Main {
    static volatile int counter=0;
    static Object lock = new Object();

    public static void main(String[] args) {
	    Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    counter++;
                    System.out.println(counter);
                    synchronized (lock) {
                        lock.notifyAll();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

	    Thread thread2 = new Thread(new TickRunnable(5));
        Thread thread3 = new Thread(new TickRunnable(7));

	    thread1.start();
	    thread2.start();
        thread3.start();
    }
}
