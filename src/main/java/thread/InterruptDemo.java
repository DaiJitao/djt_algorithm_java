package thread;

/**
 * Created by dell on 2020/4/24.
 */
public class InterruptDemo extends Thread{


    public static void main(String[] args) throws InterruptedException {
        InterruptDemo demo1 = new InterruptDemo("demo1");
        InterruptDemo demo2 = new InterruptDemo("demo2");
        demo1.start();
        demo2.start();

        Thread.sleep(50000);

        demo1.interrupt();
        System.out.println(demo1.getName() + "执行中断："+demo1.isInterrupted());
        if (demo1.isInterrupted()){
            System.out.println(demo1.getName() + "被中断了" );
        }
        Thread.sleep(10000);
        demo1.interrupt();
        Thread.sleep(10000);
        demo1.interrupt();

    }

    public InterruptDemo(String name){
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()){
            System.out.println(getName() + "正在执行..." + interrupted());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
