package futuretask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
      public static void main(String[] args) {
          //1.开启一个线程池
          ExecutorService executorService = Executors.newFixedThreadPool(1);
          //2.提交一个任务，会返回一个任务句柄
          Future<Integer> future = executorService.submit(()->{
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("future 执行完成了-"+Thread.currentThread().getName());
              return 10;
          });
         try {
             //使用返回的任务句柄获取任务执行结果
             System.out.println(Thread.currentThread().getName()+"输出-"+future.get());
         }catch (Exception e){
             e.printStackTrace();
         }
     }
}
