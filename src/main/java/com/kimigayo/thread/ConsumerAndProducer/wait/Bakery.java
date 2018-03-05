package com.kimigayo.thread.ConsumerAndProducer.wait;

public class Bakery {
    private static final Bakery bakery = new Bakery();
    private int num;
    private int manNum;
    private int size = 5;
    private Boolean test = true;

    private Bakery() {
    }

    ;

    public static Bakery getBakery() {
        return bakery;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public synchronized void eat() throws InterruptedException {
        if (this.num<=0) {
            this.wait();
        }
        if (this.getNum() > 0) {
            this.setNum(this.getNum() - 1);
            System.out.println(Thread.currentThread() + "消费面包,面包店还有" + this.getNum() + "个面包");
        } else {
            System.out.println(Thread.currentThread() + "消费失败");
        }
        if(this.num<this.size){
            this.notify();
        }
        System.out.println("客户人次"+(++this.manNum));
    }

    public synchronized void Produce() throws InterruptedException {
        if (this.num>=this.size) {
            this.wait();
        }
        this.setNum(this.getNum() + 1);
        System.out.println(Thread.currentThread() + "生产面包，面包店还有" + this.getNum() + "个面包");
        this.notifyAll();
    }

}
