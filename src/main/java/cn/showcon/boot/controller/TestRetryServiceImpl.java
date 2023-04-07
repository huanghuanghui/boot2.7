package cn.showcon.boot.controller;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TestRetryServiceImpl{
 

    @Retryable(value = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5))
    public String dignifiedTest(User user) throws Exception{
        System.out.println("dignifiedTest被调用,时间："+ LocalTime.now());
        if ("hhh".equals(user.getName())){
            throw new RuntimeException();
        }
        return user.toString();
    }


    @Retryable(value = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5))
    public String dignifiedTest(Person user) throws Exception{
        System.out.println("dignifiedTest被调用,时间："+ LocalTime.now());
        if ("hhh".equals(user.getName())){
            throw new RuntimeException();
        }
        return user.toString();
    }

    @Recover
    public String recover(User user,Exception e){
        System.out.println("回调方法执行！！！！,user"+user.toString());
        //记日志到数据库 或者调用其余的方法
        user.setName("xxxxxx");
        user.setAge("vvvvvv");
        return user.toString();
    }
    @Recover
    public String recover(Person user,Exception e){
        System.out.println("回调方法执行！！！！,user"+user.toString());
        //记日志到数据库 或者调用其余的方法
        user.setName("xxxxxx");
        user.setAge("vvvvvv");
        return user.toString();
    }
}