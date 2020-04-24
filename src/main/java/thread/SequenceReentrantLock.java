package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2020/4/24.
 */
public class SequenceReentrantLock {

    public static void main(String[] args) {
        final SequenceReentrantLock sequenceReentrantLock = new SequenceReentrantLock();
        new Thread(){
            @Override
            public void run() {
                try {
                    while (true){
                        Thread.sleep(1000);
                    System.out.println(sequenceReentrantLock.getNext());
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        System.out.println(sequenceReentrantLock.getNext());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    while (true){
                        Thread.sleep(1000);
                        System.out.println(sequenceReentrantLock.getNext());
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

    private int value;
    Lock lock = new ReentrantLock();
    Lock l1 = new ReentrantLock();

    public int getNext(){
        lock.lock();
        int a = value++;
        lock.unlock();
        return a;
    }
}
