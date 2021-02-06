import java.util.concurrent.CountDownLatch;

/**
 * @author dongfangxu
 * @date 2021/2/1 15:39
 * @description
 */
public class ThreadUseCountDownLatch extends  Fibo {

    private static volatile int value = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private Integer get() throws InterruptedException {
        countDownLatch.await();
        return value;
    }
    private void sum() {
        value = fibo(36);
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        ThreadUseCountDownLatch thread=new ThreadUseCountDownLatch();
        new Thread(() -> { thread.sum();
        }).start();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + thread.get());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }
}
