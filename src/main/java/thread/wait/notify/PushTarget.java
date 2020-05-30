package thread.wait.notify;

/**
 * Created by dell on 2020/5/25.
 */
public class PushTarget implements Runnable {

    private Tianmall tmall;

    public PushTarget(Tianmall tmall) {
        this.tmall = tmall;
    }

    public void run() {
        while(true) {
            tmall.push();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
