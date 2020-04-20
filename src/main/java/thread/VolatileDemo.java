package thread;

public class VolatileDemo {
    private volatile int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }


    public static void main(String[] args) {
        VolatileDemo demo = new VolatileDemo();
        Thread thread = new Thread(new SetterA(12, demo));
        Thread thread1 = new Thread(new GetterA(demo));
        thread.start();
        thread1.start();
    }


}

class SetterA implements Runnable {
    private VolatileDemo demo;
    private int a;

    public SetterA(int a, VolatileDemo demo) {
        this.a = a;
        this.demo = demo;
    }

    public void run() {
        demo.setA(this.a);
    }
}

class GetterA implements Runnable {
    private VolatileDemo demo;
    public GetterA(VolatileDemo demo){
        this.demo = demo;
    }
    public void run() {

        System.out.println(demo.getA());
    }
}
