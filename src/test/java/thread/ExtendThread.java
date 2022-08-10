package thread;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/7/29
 */
public class ExtendThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            System.out.println("my-thread-"+i);
        }
    }

    /**
     * 主线程，多个线程是交替执行的
     * 注意：线程开启不一定立即执行，由cpu安排调度执行
     */
    public static void main(String[] args) {
        //创建线程对象，调用run方法，主线程与副线程是交替执行
        ExtendThread extendThread = new ExtendThread();
        extendThread.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("main thread-"+i);
        }
    }
}
