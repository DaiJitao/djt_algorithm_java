package thread;

import java.util.concurrent.locks.Lock;

public class LocakDemo {
    private int a;

    public int getNext() {
        return a++;
    }

    public static void main(String[] args) {
        final LocakDemo demo = new LocakDemo();
        Thread t1 = new Thread("First ") {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + demo.getNext());
                }
            }
        };

        Thread t2 = new Thread("Second ") {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + demo.getNext());
                }
            }
        };

        Thread t3 = new Thread("Third ") {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + demo.getNext());
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();

    }
}
