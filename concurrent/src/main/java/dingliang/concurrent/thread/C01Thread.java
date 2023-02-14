package dingliang.concurrent.thread;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author WuJi
 **/
public class C01Thread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName()),"thread1");
        t1.start();

        FutureTask<Integer> t2 = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(1);
            return 1;
        });
        t2.run();
        Integer res = t2.get();
        System.out.println(res);
    }
}
