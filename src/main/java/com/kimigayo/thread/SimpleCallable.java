package com.kimigayo.thread;

import java.util.concurrent.Callable;

public class SimpleCallable implements Callable {
    private int num =100;
    public Object call() throws Exception {
        int i=0;
        for(;num>0;i++){
            System.out.println(Thread.currentThread().getName()+"==>"+num--);
        }
        return Thread.currentThread().getName()+"="+i;
    }
}
