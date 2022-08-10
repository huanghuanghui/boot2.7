package pool;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 描述:线程创建三种方式
 * - 继承Thread
 * - 实现Runnable
 * - 实现Callable
 * - 线程池方式（Java提供了构建线程池） 不允许使用Java自带的线程池创建，控制不了线程池参数，要自己手动创建线程
 * </p>
 *
 * @author hhh
 * @since 2022/7/26
 */
public class Test {
    public static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(9, 9, 10,
            TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(20), r -> {
        Thread thread = new Thread(r);
        thread.setName("My-Thread" + new Random().nextInt());
        return thread;
    }, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行" + new Random().nextInt());
            });
        }
    }
}


