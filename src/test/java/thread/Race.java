package thread;

import org.springframework.util.StringUtils;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/7/29
 */
public class Race implements Runnable{
    private static String WINNER;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            boolean flag = gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了-"+i);
        }
    }
    private boolean gameOver(int i) {
        if (StringUtils.hasLength(WINNER)){
            System.out.println("winner is "+WINNER);
            return true;
        }
        if (i>=100){
            WINNER=Thread.currentThread().getName();
            return true;
        }
        return false;
    }
    /**
     * 龟兔赛跑
     */
    public static void main(String[] args) {
        //规定同一个赛道
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟鬼").start();
    }
}
