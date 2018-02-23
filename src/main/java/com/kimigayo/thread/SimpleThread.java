package com.kimigayo.thread;

public class SimpleThread extends Thread {
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("thread==>"+i);
        }
    }
}
