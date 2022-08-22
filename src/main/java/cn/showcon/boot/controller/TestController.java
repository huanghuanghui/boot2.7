package cn.showcon.boot.controller;

import cn.showcon.boot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/8/15
 */
@RestController
public class TestController {

    /**
     * 对于有打@Lazy注解，有两层代理的情况
     * - TestService：为一个interface，默认使用JDK动态代理，会先执行CGLIB的代理在执行JDK的代理
     * - TestServiceImpl：直接是一个实现类class，默认使用CGLIB代理，有一个@Lazy，会在加一层代理，为代理的代理
     * 对于无@Lazy注解，只走切面/切点代理的情况
     * - TestService，无@Lazy，对于切面切点，使用的是实现类TestServiceImpl进行织入，所以会走CGLIB代理
     * - TestServiceImpl，无@Lazy，对于切面切点，为实现类，直接进行代理
     */
    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public void test(){
        testService.test();
    }
}
