package com.kimigayo.thread;

import java.util.concurrent.*;

public class SimpleTest {
    public static void main(String[] args){
//        SimpleThread thread = new SimpleThread();
//        Thread thread1 = new Thread(new SimpleRunnable());
//        FutureTask task = new FutureTask(new SimpleCallable());
//        Thread thread2 = new Thread(task);
//
//        thread.start();
//        thread1.start();
//        thread2.start();
//        System.out.println(task.get());

        //runnable变量同步测试,存在同步问题
//        SimpleRunnable runnable = new SimpleRunnable();
//        Thread thread1 = new Thread(runnable);
//        Thread thread2 = new Thread(runnable);
//        Thread thread3 = new Thread(runnable);
//        thread1.start();
//        thread2.start();
//        thread3.start();

        //Callable变量同步测试,存在同步问题
//        SimpleCallable callable = new SimpleCallable();
//        FutureTask task1 = new FutureTask(callable);
//        FutureTask task2 = new FutureTask(callable);
//        FutureTask task3 = new FutureTask(callable);
//        Thread thread1 = new Thread(task1);
//        Thread thread2 = new Thread(task2);
//        Thread thread3 = new Thread(task3);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        System.out.println(task1.get());
//        System.out.println(task2.get());
//        System.out.println(task3.get());

        SimpleCallable callable1 = new SimpleCallable();
        SimpleCallable callable2 = new SimpleCallable();
        ExecutorService service =  Executors.newFixedThreadPool(2);
        Future future1 = service.submit(callable1);
        Future future2 = service.submit(callable2);
        try {
            System.out.println("future1执行结果="+future1.get(1,TimeUnit.MICROSECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("future1执行超时");
        }
        try {
            System.out.println("future2执行结果="+future2.get(1,TimeUnit.MICROSECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("future2执行超时");
        }
        service.shutdownNow();
   }
}
