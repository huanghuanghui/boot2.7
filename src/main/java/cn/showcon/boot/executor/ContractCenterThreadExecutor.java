package cn.showcon.boot.executor;

import org.apache.tomcat.util.threads.TaskQueue;
import org.apache.tomcat.util.threads.TaskThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 描述:合同中心线程池，代码抄的embed tomcat org.apache.tomcat.util.net.AbstractEndpoint#createExecutor()
 * 对于标品项目需要适配不同的客户的部署环境，故线程池代码，没有自己定义线程池参数，而是参照tomcat代码编写
 * 如果需要对tomcat进行调优，那么该项目的线程池参数，也会根据tomcat 的配置进行调整
 * 该类为懒汉式单例，使用synchronized保证本有状态的bean单例线程安全
 * </p>
 *
 * @author hhh
 * @since 2022/11/16
 */
@Component
public class ContractCenterThreadExecutor {

    @Autowired
    private ApplicationContext applicationContext;

    private ThreadPoolExecutor executor = null;

    @Autowired
    private ServerProperties serverProperties;

    public synchronized ExecutorService getExecutorService() {
        if (executor != null) {
            return executor;
        }
        TaskQueue taskqueue = new TaskQueue();
        ServerProperties.Tomcat.Threads threads = serverProperties.getTomcat().getThreads();
        boolean daemon = true;
        TaskThreadFactory tf = new TaskThreadFactory(applicationContext.getId() + "-exec-", daemon, Thread.NORM_PRIORITY);
        executor = new ThreadPoolExecutor(threads.getMinSpare(), threads.getMax(), 60, TimeUnit.SECONDS, taskqueue, tf);
        return executor;
    }
}
