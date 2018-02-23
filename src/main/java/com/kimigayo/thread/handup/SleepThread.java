package com.kimigayo.thread.handup;

public class SleepThread  extends Thread {
    @Override
    public void run() {

        for (int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"==>"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SleepThread thread = new SleepThread();
        thread.start();
        for (int i=0;i<100;i++){
            if(i==50){
                Thread.sleep(2000);//当前线程暂停，不释放资源
            }
            System.out.println(Thread.currentThread().getName()+"==>"+i);
        }
    }
}
