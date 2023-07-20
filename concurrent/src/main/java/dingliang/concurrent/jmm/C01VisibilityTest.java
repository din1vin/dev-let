package dingliang.concurrent.jmm;

import dingliang.concurrent.Sleeper;
import sun.misc.Unsafe;

import java.util.concurrent.atomic.LongAdder;


/**
 * 可见性测试
 **/
public class C01VisibilityTest {
    volatile static boolean run = true;
    public static void main(String[] args) {
        new Thread(()->{
            while (run) {
                //...
                Unsafe.getUnsafe();
            }
        }).start();

        Sleeper.sleep(1);
        run = false;
        System.out.println("turn to false");
    }

}
