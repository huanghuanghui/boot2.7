package cn.showcon.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 描述:
 * </p>
 *
 * @author hhh
 * @since 2022/11/8
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "SUCCESS";
    }
}
