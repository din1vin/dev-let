package dingliang.concurrent.tool.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * @author WuJi
 **/
@Slf4j(topic = "ThreadPool")
public class C02ThreadPool {
    private final int coreSize; // 核心线程数量
    private final long timeout;
    private final TimeUnit timeUnit;
    private final C01BlockingQueue<Runnable> taskQueue;
    private final HashSet<Worker> workers = new HashSet<>();
    private final C03RejectPolicy rejectPolicy;

    public C02ThreadPool(int coreSize, long timeout, TimeUnit timeUnit, int queueCapacity, C03RejectPolicy rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new C01BlockingQueue<>(queueCapacity);
        this.rejectPolicy = rejectPolicy;
    }


    public void execute(Runnable task) {
        synchronized (workers) {
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            } else {
                taskQueue.put(task);
            }
        }
    }

    class Worker extends Thread {
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        public void run() {
            while (task != null || (task = taskQueue.taskUntil(timeout, timeUnit)) != null) {
                try {
                    task.run();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    task = null; //任务运行结束或者报错后把当前任务置为null
                }
            }

            synchronized (workers) {
                workers.remove(this);
            }
        }
    }
}

