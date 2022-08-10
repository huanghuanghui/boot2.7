package pool;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/7/26
 */
public class Test3 {

    public static void main(String[] args) {
        Test.threadPoolExecutor.execute(()->{
            System.out.println(Thread.currentThread().getName()+"执行3");
        });
    }
}
