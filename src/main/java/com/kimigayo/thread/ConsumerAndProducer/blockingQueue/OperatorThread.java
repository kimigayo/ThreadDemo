package com.kimigayo.thread.ConsumerAndProducer.blockingQueue;

public class OperatorThread extends Thread {
    private Bank bank;

    public OperatorThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while(true){
            this.bank.finish();
        }
    }
}
