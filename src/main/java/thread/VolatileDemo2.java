package thread;

public class VolatileDemo2 {
    volatile boolean isRun = false;

    public static void main(String[] args) {
        final VolatileDemo2 demo2 = new VolatileDemo2();
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {

                    System.err.println("次数" + i);
                }
                demo2.isRun = true;
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (!demo2.isRun) {

                }
                System.out.println(Thread.currentThread().getName() + " 开始执行...");
            }
        }.start();
    }
}
