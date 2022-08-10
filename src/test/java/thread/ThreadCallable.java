package thread;

import org.apache.tomcat.util.ExceptionUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/7/29
 */
public class ThreadCallable implements Callable {
    @Override
    public Boolean call() throws Exception {
        System.out.println("xxx");
        return true;
    }
    public static void main(String[] args)throws Exception {
        //开启线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //提交任务
        Future submit = executorService.submit(new ThreadCallable());
        //获取任务执行结果
        submit.get();
        //任务完成，关闭线程池，不然线程池中会有一个阻塞队列，线程池会阻塞，等待任务
        if (submit.isDone()){
            executorService.shutdownNow();
        }
    }
}
