package com.kimigayo.thread.ConsumerAndProducer.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Bank {
    private BlockingQueue queue = new LinkedBlockingQueue(6);

    public void work(){
        try {
            queue.put(1);
            System.out.println("客户进入"+Thread.currentThread().getName()+"开始办理一个业务，工作窗口个数="+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void finish(){
        try {
            queue.take();
            System.out.println("银行工作"+Thread.currentThread().getName()+",办理完成一个业务，工作窗口个数="+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
