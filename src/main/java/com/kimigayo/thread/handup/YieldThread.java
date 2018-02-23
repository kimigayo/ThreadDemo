package com.kimigayo.thread.handup;

public class YieldThread extends Thread {
    @Override
    public void run() {

        for (int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"==>"+i);
        }
    }

    public static void main(String[] args) {
        YieldThread thread = new YieldThread();
        thread.start();
        for (int i=0;i<100;i++){
            if(i%5==0){
                Thread.yield();//当前线程挂起，释放资源
            }
            System.out.println(Thread.currentThread().getName()+"==>"+i);
        }
    }
}
