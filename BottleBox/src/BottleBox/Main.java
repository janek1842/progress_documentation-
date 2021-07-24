package BottleBox;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Box box = new Box();

        Lock lock = new ReentrantLock();
        Condition waiting = lock.newCondition();

        MachineForBottleProduction machine1 = new MachineForBottleProduction(box,lock,waiting);
        MachineChangeBox machine2 = new MachineChangeBox(box,lock,waiting);

        Thread production = new Thread(machine1, "Producent");
        Thread changer = new Thread(machine2, "Changer");

        production.start();
        changer.start();
    }
}

class MachineForBottleProduction implements Runnable {
    private Box box;
    private int i = 0;

    @Override
    public void run() {
        try {
            synchronized (box) {
                System.out.println(Thread.currentThread().getName() + " Let's Begin production ! ");
                while (true) {
                    while (box.isFull()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " Change Box, this one is full ");
                            condition.await();
                            System.out.println(Thread.currentThread().getName() + "I'm back !");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(Thread.currentThread().getName() + "I produced " + (++i) + " bottle");
                    box.add(new Bottle());

                    condition.signalAll();
                }
            }
        }
        finally {
            lock.unlock();
        }

    }

    public MachineForBottleProduction(Box box,Lock lock,Condition condition) {
        this.box = box;
        this.lock = lock;
        this.condition=condition;
    }

    Lock lock;
    Condition condition;
}

class MachineChangeBox implements Runnable {
    Box box;

    @Override
    public void run() {

        lock.lock();
        try {
            synchronized (box) {
                System.out.println(Thread.currentThread().getName() + " I am preparing to change the box");
                while (true) {
                    System.out.println(Thread.currentThread().getName() + ": Ino ");
                    while (!box.isFull()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " I am back to changing");
                            box.wait();
                            System.out.println(Thread.currentThread().getName() + " I am back to changing");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    box.getNumberOfBottles();
                    box.change();
                    box.getNumberOfBottles();

                    condition.signalAll();
                }
            }
        }finally {
            lock.unlock();
        }

    }

    public MachineChangeBox(Box box,Lock lock,Condition condition) {
        this.box = box;
        this.lock = lock;
        this.condition=condition;
    }

    Lock lock;
    Condition condition;
}

class Box {
    public synchronized boolean isFull() {
        if (bottleLIst.size() == capacity) {
            return true;
        }
        return false;

    }

    public synchronized int getNumberOfBottles() {
        System.out.println(Thread.currentThread().getName() + " Now in box:  " + this.bottleLIst.size());
        return this.bottleLIst.size();
    }

    public synchronized void add(Bottle bottle) {
        bottleLIst.add(bottle);
    }

    public synchronized void change() {
        System.out.println(Thread.currentThread().getName() + " I am changing boxes  " + this.bottleLIst.size());
        bottleLIst.clear();
    }

    private final int capacity = 10;
    private ArrayList bottleLIst = new ArrayList(capacity);
}

class Bottle {

}