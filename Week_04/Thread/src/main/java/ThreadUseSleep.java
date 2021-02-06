/**
 * @author dongfangxu
 * @date 2021/2/1 15:39
 * @description
 */
public class ThreadUseSleep extends  Fibo {

    public volatile static Integer value = 0;

    private  void sum() {
        value = fibo(36);
    }

    private Integer get() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        ThreadUseSleep thread = new ThreadUseSleep();
        new Thread(() -> { thread.sum();
        }).start();


        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + thread.get());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }
}
