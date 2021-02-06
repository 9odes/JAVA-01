import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author dongfangxu
 * @date 2021/2/1 15:39
 * @description
 */
public class ThreadUseFutureTask extends  Fibo {

    public volatile static Integer value = 0;

    private  void sum() {
        value = fibo(36);
    }

    private Integer get() {
        return value;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        ThreadUseFutureTask thread=new ThreadUseFutureTask();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            thread.sum();
            return thread.get();
        });

        new Thread(futureTask).start();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + futureTask.get());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }
}
