import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongfangxu
 * @date 2021/2/1 15:39
 * @description
 */
public class ThreadUseReentrantLock extends  Fibo {

    private static volatile Integer value = null;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private void sum() {
        lock.lock();
        try {
            value = fibo(36);
            condition.signal();
        } finally {
            lock.unlock();
        }

    }
    private Integer get() throws InterruptedException {
        lock.lock();
        try {
            while (value == null) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
        return value;
    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        ThreadUseReentrantLock thread=new ThreadUseReentrantLock();
        new Thread(() -> { thread.sum();
        }).start();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + thread.get());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }
}
