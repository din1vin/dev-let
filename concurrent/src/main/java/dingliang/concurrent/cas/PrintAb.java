package dingliang.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintAb {
    public static void main(String[] args) {
        AtomicInteger  cas = new AtomicInteger(0);
        new Thread(()->{
            while(cas.get() %2 == 0){
                System.out.println("A");
                cas.decrementAndGet();
            }
        });
    }
}
