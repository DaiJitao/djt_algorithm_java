package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by dell on 2020/5/8.
 */
public class MyLock implements Lock {
    Helpler helpler = new Helpler();
    public void lock() {
        helpler.acquire(1);
    }

    public void lockInterruptibly() throws InterruptedException {
        helpler.acquireInterruptibly(1);

    }

    public boolean tryLock() {
        return helpler.tryAcquire(1);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helpler.tryAcquireNanos(1, unit.toNanos(time));
    }

    public void unlock() {
        helpler.release(1);

    }

    public Condition newCondition() {
        return helpler.newCondition();
    }

    private class Helpler extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            Thread thread = Thread.currentThread();
            if (state == 0){
                if (compareAndSetState(0, arg)){
                    setExclusiveOwnerThread(thread);
                    return true;
                }
            } else if(getExclusiveQueuedThreads() == thread){
                setState(state+1);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (Thread.currentThread() != getExclusiveOwnerThread()){
                throw new RuntimeException();
            }
            int state = getState() - arg;
            boolean flag = false;
            if (state == 0){
                setExclusiveOwnerThread(null);
                flag = true;
            }
            setState(state);
            return flag;
        }
        Condition newCondition() {
            return new ConditionObject();
        }

    }
}
