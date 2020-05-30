package thread;

/**
 * Created by dell on 2020/5/8.
 */
public class MyLockMain {
    public static void main(String[] args) {
        final MyLockMain lockMain = new MyLockMain();
        new Thread() {
            @Override
            public void run() {
                while (true)
                System.out.println(Thread.currentThread().getId() + " " + lockMain.next());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true)
                System.out.println(Thread.currentThread().getId() + " " + lockMain.next());
            }
        }.start();
    }

    private int value;
    private MyLock lock = new MyLock();

    public int next() {
        lock.lock();
        try {
            Thread.sleep(300);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }
    }

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }
}
