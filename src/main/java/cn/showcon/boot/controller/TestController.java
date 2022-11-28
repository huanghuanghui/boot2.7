package cn.showcon.boot.controller;

import cn.showcon.boot.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/boot/test/{id}")
    public Integer test(@PathVariable Integer id){
        return id;
    }

    @PostMapping("/boot/post")
    public String test(@RequestBody User user){
        return user.toString();
    }
}
