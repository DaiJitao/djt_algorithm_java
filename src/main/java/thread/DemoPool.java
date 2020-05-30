package thread;

import org.apache.kafka.common.protocol.types.Field;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dell on 2020/5/19.
 */
public class DemoPool {
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
//        Task task = new Task();
//        pool.execute(task);

        Map<String, String> map = new LinkedHashMap<String, String>();
        System.out.println(map.remove("test"));
    }
}

class Task implements Runnable{
    public void run() {
       int   count = 1;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + (count++));
        }
    }
}
