package com.kimigayo.thread.ConsumerAndProducer.blockingQueue;

public class CorrespondentThread extends Thread{
    private Bank bank;

    public CorrespondentThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for(int i =0;i<100;i++){
            this.bank.work();
        }
    }
}
