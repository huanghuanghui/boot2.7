package cn.showcon.boot.invocationhandler;

import org.junit.Assert;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2023/1/3
 */
public class Test {
    public static void main(String[] args) {
        AddService service = new AddServiceImpl();
        AddServiceHandler addServiceHandler = new AddServiceHandler(service);
        AddService proxy = addServiceHandler.getProxy();
        Assert.assertEquals(3, proxy.add(1, 2));
    }
}
