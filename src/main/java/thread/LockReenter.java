package thread;

/**
 * 锁的重新入进去演示
 */
public class LockReenter {
    public synchronized void a(){
        System.out.println("a");
        b();
    }

    public synchronized void b(){
        System.out.println("b");
    }

    public static void main(String[] args) {

        Runnable demo = new Runnable() {
            public void run() {
                LockReenter lockReenter = new LockReenter();
                lockReenter.a();
            }
        };

        new Thread(demo).start();
    }
}
