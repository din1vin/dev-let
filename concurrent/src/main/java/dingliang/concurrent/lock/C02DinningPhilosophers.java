package dingliang.concurrent.lock;

import dingliang.concurrent.Sleeper;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 死锁问题模拟: 哲学家就餐问题
 **/
public class C02DinningPhilosophers {
    public static void main(String[] args) {
        Chopsticks c1 = new Chopsticks("c1");
        Chopsticks c2 = new Chopsticks("c2");
        Chopsticks c3 = new Chopsticks("c3");
        Chopsticks c4 = new Chopsticks("c4");
        Chopsticks c5 = new Chopsticks("c5");
        new Philosopher("苏格拉底", c1, c2).start();
        new Philosopher("亚里士多德", c2, c3).start();
        new Philosopher("阿基米德", c3, c4).start();
        new Philosopher("柏拉图", c4, c5).start();
        new Philosopher("郝拉克里特", c5, c1).start();
    }
}


//筷子类
class Chopsticks {
    private final String name;

    public Chopsticks(String name) {
        this.name = name;
    }
}

// 哲学家类
class Philosopher extends Thread {
    private final String name;
    private final Chopsticks left;
    private final Chopsticks right;

    public Philosopher(String name, Chopsticks left, Chopsticks right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        for (; ; ) {
            synchronized (left) {
                synchronized (right) {
                    eat();
                }
            }
        }
    }

    private void eat() {
        System.out.println(LocalDateTime.now() + "=>" + name );
        Sleeper.sleep(1, TimeUnit.SECONDS);
    }
}
