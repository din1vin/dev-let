package dingliang.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author WuJi
 **/
public class Sleeper {
    public static void sleep(int d, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(d);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleep(int sec){
        sleep(sec,TimeUnit.SECONDS);
    }
}
