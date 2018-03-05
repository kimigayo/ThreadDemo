package com.kimigayo.thread.ConsumerAndProducer.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class BarberShop {
    private int BarberNum = 6;
    private int consumerNum = 0;
    private Lock lock;
    private String name;
    private Condition BarberCondition;
    private Condition consumerCondition;

    public BarberShop(Lock lock, Condition barberCondition, Condition consumerCondition) {
        this.lock = lock;
        BarberCondition = barberCondition;
        this.consumerCondition = consumerCondition;
    }

    public void consume() {
        this.lock.lock();
        try {
            if (this.consumerNum > BarberNum) {
                System.out.println("一位客人进入等待");
                try {
                    consumerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.consumerNum = this.consumerNum + 1;
            System.out.println("一位客人开始理发,工作理发师=" + (this.consumerNum));
            BarberCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void barberFinish() {
        lock.lock();
        try {
            if (this.consumerNum > 0) {
                this.consumerNum = this.consumerNum - 1;
                System.out.println("一位理发师理发结束，工作理发师=" + this.consumerNum);
                consumerCondition.signalAll();
            } else {
                try {
                    BarberCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("进入等待的理发师="+(BarberNum-consumerNum));
        } finally {
            lock.unlock();
        }
    }
}
