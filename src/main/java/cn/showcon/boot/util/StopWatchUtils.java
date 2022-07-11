package cn.showcon.boot.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/6/27
 */
@Slf4j
public class StopWatchUtils {
    public static StopWatch getWatch(String taskName) {
        StopWatch watch = new StopWatch();
        watch.start(taskName);
        return watch;
    }

    public static StopWatch getWatch() {
        return getWatch("");
    }


    public static void stop(StopWatch watch) {
        watch.stop();
        log.info("{}操作耗时： {} ms", watch.getLastTaskName(), watch.getLastTaskTimeMillis());
    }

    public static void sleep(String taskName, long time) {
        log.info("{}睡眠等待：{} ms", taskName, time);
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            log.error("睡眠出错：", e);
        }
    }

}
