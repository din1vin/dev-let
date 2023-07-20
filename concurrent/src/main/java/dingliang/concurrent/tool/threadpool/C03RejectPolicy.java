package dingliang.concurrent.tool.threadpool;

@FunctionalInterface
public interface C03RejectPolicy<T> {
    void reject(C01BlockingQueue<T> blockingQueue, T element);
}
