package dingliang.concurrent.tool.threadpool;

/**
 * @author WuJi
 **/
public class C03WaitForever<T> implements C03RejectPolicy<T>{

    @Override
    public void reject(C01BlockingQueue<T> blockingQueue, T element) {
        blockingQueue.put(element);
    }
}
