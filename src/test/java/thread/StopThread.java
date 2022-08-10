package thread;

import java.util.concurrent.Callable;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/7/29
 */
public class StopThread implements Runnable {

    private static Boolean FLAG=Boolean.TRUE;

    @Override
    public void run(){
        while (FLAG){
            System.out.println("thread execute");
            //给个标识让线程自然停止
            FLAG=false;
        }
    }
    /**
     * 停止线程
     * - 不推荐使用JDK提供的stop方法，JDK也已经将stop方法废弃
     * - 推荐线程自己判断执行完成后停止，例如本例子中
     */
    public static void main(String[] args) {
        new Thread(new StopThread()).start();
    }
}
