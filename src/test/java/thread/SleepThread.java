package thread;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/7/29
 */
public class SleepThread implements Runnable {

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
     * 线程休眠
     * - sleep时间达到以后线程进入就绪状态，等待CPU调度执行
     * - 每个对象都有一个锁，sleep不会释放对象锁
     *
     * 线程礼让
     * - 礼让线程，当前正在执行的线程暂停，但不阻塞
     * - 将线程从运行状态转为就绪状态
     * - 让CPU重新调度，礼让不一定成功，要看CPU心情
     *
     * Join
     * - join何必线程，待此线程执行完成后，执行其他线程，其他线程阻塞
     * - 可以想象为插队
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new SleepThread());
        thread.start();
        Thread.State state = thread.getState();
    }
}
