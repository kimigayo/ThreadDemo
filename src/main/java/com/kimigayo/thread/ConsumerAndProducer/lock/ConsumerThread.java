package com.kimigayo.thread.ConsumerAndProducer.lock;

public class ConsumerThread extends Thread{
    private BarberShop barberShop;

    public ConsumerThread(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (1000 * Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){
            barberShop.consume();
        }
    }
}
