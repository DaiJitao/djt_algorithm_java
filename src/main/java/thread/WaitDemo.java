package thread;

/**
 * Created by dell on 2020/4/24.
 */
public class WaitDemo implements Runnable {
    public static void main(String[] args) {
        WaitDemo demo = new WaitDemo();

        Thread thread = new Thread(demo);
        thread.start();

        while (true){
            synchronized (demo){
                System.out.println("主线程开始唤醒");
                demo.notifyAll();
            }
        }
    }

    public synchronized void run() {
        while (true){
            try {
                wait();
                System.out.println("等待完毕！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
