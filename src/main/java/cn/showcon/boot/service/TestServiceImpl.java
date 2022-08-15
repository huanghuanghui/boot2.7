package cn.showcon.boot.service;

import org.springframework.stereotype.Component;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/8/15
 */
@Component
public class TestServiceImpl implements TestService{
    @Override
    public void test() {
        System.out.println("invoke test method");
    }
}
