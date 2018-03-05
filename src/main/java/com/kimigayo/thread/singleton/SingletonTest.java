package com.kimigayo.thread.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        for(int i=0;i<=10000;i++){
            Thread thread = new Thread(new SingleTest());
            thread.start();
        }
    }

    static class SingleTest implements Runnable{
        public void run() {
            DoubleCheckSingleton checkSingleton = DoubleCheckSingleton.getInstanceSelf();
            System.out.println(checkSingleton);
            System.out.println(checkSingleton.getInstance());
        }
    }
}
