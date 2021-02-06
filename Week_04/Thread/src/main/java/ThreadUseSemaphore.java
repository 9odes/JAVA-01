import java.util.concurrent.Semaphore;

/**
 * @author dongfangxu
 * @date 2021/2/1 15:39
 * @description
 */
public class ThreadUseSemaphore extends  Fibo {

    public volatile static Integer value = 0;

    private final static Semaphore semaphore = new Semaphore(1);

    public ThreadUseSemaphore() throws InterruptedException {
        semaphore.acquire();
    }

    private void sum() {
        value = fibo(36);
        semaphore.release();
    }

    private Integer get() throws InterruptedException {
        //在此处进行了抢占
        semaphore.acquire();
        semaphore.release();
        return value;
    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        ThreadUseSemaphore thread = new ThreadUseSemaphore();
        new Thread(() -> { thread.sum();
        }).start();


        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + thread.get());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }
}
