/**
 * @author dongfangxu
 * @date 2021/2/1 15:39
 * @description
 */
public class ThreadUseSync extends  Fibo {

    public volatile static Integer value = 0;

    private synchronized void sum() {
        value = fibo(36);
        this.notifyAll();
    }

    private synchronized Integer get() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ThreadUseSync thread=new ThreadUseSync();
        new Thread(() -> { thread.sum();
        }).start();


        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + thread.get());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }
}
