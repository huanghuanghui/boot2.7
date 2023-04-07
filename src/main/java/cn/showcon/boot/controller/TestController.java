package cn.showcon.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Recover;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/11/14
 */
@RestController
public class TestController {

    @Autowired
    TestRetryServiceImpl retryService;
    @GetMapping("/test")
    public String test(String name,String age)throws Exception{
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return retryService.dignifiedTest(user);
    }
    @GetMapping("/test2")
    public String test2(String name,String age)throws Exception{
        Person user = new Person();
        user.setName(name);
        user.setAge(age);
        return retryService.dignifiedTest(user);
    }

}
