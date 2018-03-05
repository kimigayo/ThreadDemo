package com.kimigayo.thread;

import java.util.concurrent.Callable;

public class SimpleCallable implements Callable {
    private int num = 1000;

    public Object call() throws Exception {
        int i = 0;
        while(true) {
            synchronized (this) {
                if (num > 0) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "==>" + num--);
                }else {
                    break;
                }
            }
        }
        Thread.sleep(2000);
        return Thread.currentThread().getName() + "=" + i;
    }
}
