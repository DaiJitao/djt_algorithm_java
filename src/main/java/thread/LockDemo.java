package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2020/5/7.
 */
public class LockDemo {
    public static void main(String[] args) {
        for (int i = 0;i<10;i++){
            new Thread(new Runnable() {
                public void run() {
                    LockDemo.inc();
                }
            }).start();
            System.out.println(LockDemo.count);
        }

    }

    private static int count = 0;
    static Lock lock= new ReentrantLock();

    public static void inc(){
        lock.lock();
        try {
            Thread.sleep(100);
            count ++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
