import java.util.concurrent.CompletableFuture;

/**
 * @author dongfangxu
 * @date 2021/2/1 15:39
 * @description
 */
public class ThreadUseCompletableFuture extends  Fibo {

    private static int sum() {
        return fibo(36);
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Integer result = CompletableFuture.supplyAsync(ThreadUseCompletableFuture::sum).join();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }
}
