package com.kimigayo.thread.handup;

public class JoinThread extends Thread {
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"==>"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinThread thread = new JoinThread();
        thread.start();
        for (int i=0;i<100;i++){
            if(i==50){
                thread.join();//thread线程阻塞mian线程
            }
            System.out.println(Thread.currentThread().getName()+"==>"+i);
        }
    }
}
