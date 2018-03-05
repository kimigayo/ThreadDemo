package com.kimigayo.thread.ConsumerAndProducer.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BarberShopTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        BarberShop barberShop = new BarberShop(lock,condition1,condition2);
        BarberThread barberThread = new BarberThread(barberShop);
        ConsumerThread consumerThread = new ConsumerThread(barberShop);
        barberThread.start();
        consumerThread.start();
    }
}
