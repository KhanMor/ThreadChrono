package com.kharkhanov;

/**
 * Created by Mordr on 09.02.2017.
 */
public class TickRunnable implements Runnable{
    private int tick;

    public TickRunnable(int tick){
        this.tick=tick;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (Main.lock) {
                try {
                    Main.lock.wait();
                    if (Main.counter % tick == 0) {
                        System.out.println("My tick is "+tick);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
