package dingliang.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程 t1,t2,t3 分别打印a b c, 按照abc的顺序交替打印各5次
 **/
public class C03AlternatePrint {
    static Thread a;
    static Thread b;
    static Thread c;

    public static void main(String[] args) {
        /* wait-notify
        System.out.println("WaitNotify:");
        WaitNotify wn = new WaitNotify("A", 5);
        new Thread(() -> wn.print("A", "B")).start();
        new Thread(() -> wn.print("B", "C")).start();
        new Thread(() -> wn.print("C", "A")).start();
        System.out.println();
        */

        /*  await-signal
        System.out.println("AwaitSignal");
        AwaitSignal as = new AwaitSignal(5);
        Condition a = as.newCondition();
        Condition b = as.newCondition();
        Condition c = as.newCondition();
        as.lock();
        try {
            new Thread(() -> as.print("A", a, b)).start();
            new Thread(() -> as.print("B", b, c)).start();
            new Thread(() -> as.print("C", c, a)).start();
            a.signalAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            as.unlock();
        }
        */


        Park park = new Park(5);
        a = new Thread(() -> park.print("a", b));
        b = new Thread(() -> park.print("b", c));
        c = new Thread(() -> park.print("c", a));
        a.start();
        b.start();
        c.start();
    }
}

// 使用wait-notify 实现
class WaitNotify {
    private String alpha;
    private int loopNum;

    public WaitNotify(String alpha, int loopNum) {
        this.alpha = alpha;
        this.loopNum = loopNum;
    }


    public void print(String current, String next) {
        synchronized (this) {
            for (int i = 0; i < loopNum; i++) {
                while (!current.equals(alpha)) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(current);
                alpha = next;
                this.notifyAll();
            }
        }
    }
}


// 使用await-signal实现

class AwaitSignal extends ReentrantLock {
    private final int loopNum;

    public AwaitSignal(int loopNum) {
        this.loopNum = loopNum;
    }

    public void print(String print, Condition current, Condition next) {
        for (int i = 0; i < loopNum; i++) {
            lock();
            System.out.println("获得锁");
            try {
                current.await();
                System.out.print(print);
                next.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                unlock();
            }

        }
    }
}

class Park {
    private final int loopNum;

    public Park(int loopNum) {
        this.loopNum = loopNum;
    }

    public void print(String content, Thread next) {
        for (int i = 0; i < loopNum; i++) {
            LockSupport.park();
            System.out.print(content);
            LockSupport.unpark(next);
        }
    }
}

