/**
 * @author dongfangxu
 * @date 2021/2/1 15:39
 * @description
 */
public class ThreadUseJoin extends Fibo{
    private static volatile Integer value = null;

    private  void sum() {
        value = fibo(36);
    }

    private  Integer get() {
        return value;
    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        ThreadUseJoin thread=new ThreadUseJoin();

        Thread t = new Thread(() -> { thread.sum(); });
        t.start();
        t.join();
        System.out.println("异步计算结果为："+thread.get());
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}
