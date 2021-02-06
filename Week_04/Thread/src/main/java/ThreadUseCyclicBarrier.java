import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author dongfangxu
 * @date 2021/2/1 15:39
 * @description
 */
public class ThreadUseCyclicBarrier extends  Fibo {

    public volatile static Integer value = 0;

    CyclicBarrier barrier = new CyclicBarrier(1,new SumRunnable());

    private Integer get() throws BrokenBarrierException, InterruptedException {
        barrier.await();
        return value;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        ThreadUseCyclicBarrier thread=new ThreadUseCyclicBarrier();

        new Thread(new SumRunnable()).start();

        int result = 0;
        try {
            result = thread.get();
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    static class SumRunnable extends Fibo implements Runnable{

        @Override
        public void run() {
            value = fibo(36);
        }
    }
}
