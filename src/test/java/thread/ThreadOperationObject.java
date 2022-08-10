package thread;

/**
 * <p>
 * 描述:多个线程操作同一个对象
 * </p>
 *
 * @author hhh
 * @since 2022/7/29
 */
public class ThreadOperationObject implements Runnable{

    private int ticketNumber=10;

    @Override
    public void run() {
        while (true){
            if (ticketNumber<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+":拿到了:"+ticketNumber+"票");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticketNumber--;
        }
    }

    public static void main(String[] args) {
        ThreadOperationObject threadOperationObject = new ThreadOperationObject();

        new Thread(threadOperationObject,"小明").start();
        new Thread(threadOperationObject,"小黄").start();
        new Thread(threadOperationObject,"小王").start();
    }
}
