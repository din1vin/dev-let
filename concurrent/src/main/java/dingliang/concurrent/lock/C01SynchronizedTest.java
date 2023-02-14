package dingliang.concurrent.lock;

import dingliang.concurrent.Sleeper;

import java.util.concurrent.TimeUnit;

/**
 * 锁粗化测试
 **/
public class C01SynchronizedTest {
    static int counter = 0;
    final static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        long t = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 500; i++) {
                    Sleeper.sleep(3, TimeUnit.MICROSECONDS);
                    counter++;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 500; i++) {
                    Sleeper.sleep(3, TimeUnit.MICROSECONDS);
                    counter--;
                }
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter);
        System.out.println("use: " + (System.currentTimeMillis() - t));
    }
}
