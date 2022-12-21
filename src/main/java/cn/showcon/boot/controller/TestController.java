package cn.showcon.boot.controller;

import cn.showcon.boot.entity.User;
import cn.showcon.boot.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserDao userDao;

    @GetMapping("/test")
    public String test(){
        User userById = userDao.getUserById(1L);
        return userById.getName();
    }
}
