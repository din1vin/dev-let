package dingliang.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 使用信号量来控制打印AB <p>
 * 信号量有两种方法 acquire和 release分别使 semaphore -1 和 +1<p>
 * 当 semaphore >0 可以继续执行acquire之后的代码
 */
public class PrintAB {
    public static void main(String[] args) {
        final int loopTimes = 10;
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
         new Thread(() -> {
            for (int i = 0; i < loopTimes; i++) {
                try {
                    s1.acquire();
                    System.out.print("A");
                    s2.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"threadA").start();
         new Thread(() -> {
            for (int i = 0; i < loopTimes; i++) {
                try {
                    s2.acquire();
                    System.out.print("B");
                    s1.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        },"threadB").start();
    }
}
