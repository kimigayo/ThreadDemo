package com.kimigayo.thread.ConsumerAndProducer.wait;

public class ManTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Bakery.getBakery().eat();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Bakery.getBakery().Produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);
        thread.start();
        thread2.start();
   }
}
