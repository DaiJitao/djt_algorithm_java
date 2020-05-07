package thread;

/**
 * Created by dell on 2020/4/24.
 */
public class InterruptionInJava implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptionInJava());
        thread.start();
        Thread.sleep(2000);
        InterruptionInJava.on = true;
        Thread.sleep(5000);
        System.out.println("状态：" + thread.isInterrupted());
        thread.interrupt();
        thread.interrupt();
        System.out.println("状态：" + thread.isInterrupted());
        System.out.println("end");
    }

    private volatile static boolean on = false;
    public void run() {
        while (!on){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("caught exception right now: "+e);
            }
        }
    }
}
