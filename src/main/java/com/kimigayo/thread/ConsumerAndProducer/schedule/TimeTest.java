package com.kimigayo.thread.ConsumerAndProducer.schedule;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行"+System.currentTimeMillis());
            }
        },System.currentTimeMillis()+1000,200);
    }
}
