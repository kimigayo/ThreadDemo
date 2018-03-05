package com.kimigayo.thread.ConsumerAndProducer.blockingQueue;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        OperatorThread thread = new OperatorThread(bank);
        CorrespondentThread thread1 = new CorrespondentThread(bank);
        thread.start();
        thread1.start();
    }
}
