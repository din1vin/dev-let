package dingliang.concurrent.thread;

import java.io.PrintStream;

public class C02Test {
    static boolean isStop =false;

    public static void main(String[] args) throws InterruptedException {
        PrintStream out = System.out;
        new Thread(()->{
            while(!isStop){
                synchronized (out){
                    out.println("xx");
                }
            }
            out.println(Thread.currentThread() + " stop ");
        },"t1").start();
        Thread.sleep(1000);

        new Thread(()->{
            isStop = true;
            out.println(Thread.currentThread() + " flag changed");
        },"t2").start();

        Thread.sleep(1000);
    }
}
