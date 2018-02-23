package com.kimigayo.thread;

public class SimpleRunnable implements Runnable {
    private int num =100000;
    @Override
    public void run() {

        int i=0;
        for(;num>0;i++){
            System.out.println(Thread.currentThread().getName()+"==>"+num--);
        }
        System.out.println(Thread.currentThread().getName()+"=============>"+num--);
    }
}
