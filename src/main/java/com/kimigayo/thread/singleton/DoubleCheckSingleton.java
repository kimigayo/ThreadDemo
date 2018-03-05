package com.kimigayo.thread.singleton;

public class DoubleCheckSingleton {
    private static DoubleCheckSingleton singleton = null;
    private static class Car{
        public static final Car car = new Car();
    }
    public Car getInstance(){
        return Car.car;
    }

    private DoubleCheckSingleton(){};

    public static DoubleCheckSingleton getInstanceSelf(){
        if(null==singleton){
            synchronized (DoubleCheckSingleton.class){
                if(null==singleton){
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
