package dingliang.concurrent.tool.threadpool;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WuJi
 **/
@Slf4j(topic = "BlockingQueue")
@Getter
public class C01BlockingQueue<T> {
    private final int capacity;
    private final Deque<T> queue = new ArrayDeque<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition isFull = lock.newCondition();
    private final Condition isEmpty = lock.newCondition();

    public C01BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public T take() {
        lock.lock();
        try {
            while (queue.size() == 0) {
                isEmpty.await();
            }
            T t = queue.removeFirst();
            isFull.signalAll();
            return t;
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            return null;
        } finally {
            lock.unlock();
        }
    }


    public T taskUntil(long timeOut, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeOut);
            while (queue.size() == 0) {
                if (nanos <= 0) {
                    log.info("wait for take timeout");
                    return null;
                }
                nanos = isEmpty.awaitNanos(nanos);
            }
            T t = queue.removeFirst();
            log.info("take one from blockingQueue: {}", t);
            isFull.signalAll();
            return t;
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            return null;
        } finally {
            lock.unlock();
        }
    }

    public void put(T t) {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                isFull.await();
            }
            queue.addLast(t);
            isEmpty.signalAll();
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        } finally {
            lock.unlock();
        }
    }

    public void putUtil(T t, long timeout, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            while (queue.size() == capacity) {
                if (nanos <= 0) {
                    log.info("put timeout, not wait anymore");
                    return;
                }
                nanos = isFull.awaitNanos(nanos);
            }
            queue.addLast(t);
            log.info("one element add to blockingQueue : {}", t);
            isEmpty.signalAll();
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        } finally {
            lock.unlock();
        }
    }

    public void putWithRejectPolicy(T element, C03RejectPolicy<T> rejectPolicy) {
        lock.lock();
        try {
            if (queue.size() == capacity) {
                rejectPolicy.reject(this, element);
            } else {
                queue.addLast(element);
                log.info("put one element into blockingQueue: {}", element);
                isEmpty.signalAll();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            lock.unlock();
        }
    }
}
