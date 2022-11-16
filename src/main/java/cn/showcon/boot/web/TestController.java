package cn.showcon.boot.web;

import cn.showcon.boot.MyResponse;
import cn.showcon.boot.executor.ContractCenterThreadExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RestController
public class TestController {
    @Autowired
    private ContractCenterThreadExecutor contractCenterThreadExecutor;

    @GetMapping("/getObject")
    public MyResponse getObject() {
        return new MyResponse(200, "success");
    }

    @GetMapping("/getString")
    public String getString() {
        return "SUCCESS";
    }

    @GetMapping("/thread")
    public Integer thread() {
        Long begin = System.currentTimeMillis();
        Integer result = 0;
        ExecutorService executorService = contractCenterThreadExecutor.getExecutorService();
//        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<Integer> c = () -> {
            Long start = System.currentTimeMillis();
            while (true) {
                Long current = System.currentTimeMillis();
                if ((current - start) > 1000) {
                    return 1;
                }
            }
        };
        Callable<Integer> c1 = () -> {
            //新开线程，需要传递线程变量
            Long start = System.currentTimeMillis();
            while (true) {
                Long current = System.currentTimeMillis();
                if ((current - start) > 1000) {
                    return 2;
                }
            }
        };
        Future<Integer> future = executorService.submit(c);
        Future<Integer> future1 = executorService.submit(c1);
        try {
            result = future.get();
            result = result + future1.get();
        } catch (InterruptedException | ExecutionException executionException) {

        }
        Long end = System.currentTimeMillis();
        System.out.println(end - begin);
        return result;
    }
}
