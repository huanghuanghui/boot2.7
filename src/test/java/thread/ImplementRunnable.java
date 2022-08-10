package thread;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/7/29
 */
public class ImplementRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            System.out.println("ImplementRunnable Thread:"+i);
        }
    }

    public static void main(String[] args) {
        new Thread(new ImplementRunnable()).start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("MAIN Thread:"+i);
        }
    }
}
