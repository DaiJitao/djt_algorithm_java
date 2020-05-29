package thread.wait.notify;

/**
 * Created by dell on 2020/5/25.
 */
public class Tianmall {

    private int count = 0;
    public final int MAX_COUNT = 10;

    public synchronized void push(){
        while (count >= MAX_COUNT){
            System.out.println(Thread.currentThread().getName() + " 库存数量达到上限，生产者停止生产。");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count++;
        System.out.println(Thread.currentThread().getName() + " 生产者生产，当前库存为：" + count);
        notifyAll();
    }

    public synchronized void take(){
        while (count < 0 ){
            System.out.println(Thread.currentThread().getName() + " 库存数量为零，消费者等待。");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count --;
        System.out.println(Thread.currentThread().getName() + " 消费者消费，当前库存为：" + count);
        notifyAll();
    }
}
