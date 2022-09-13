package cn.showcon.boot.web;

import cn.showcon.boot.MyResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/getXxx")
    public MyResponse getXxx() {
        return new MyResponse(200,"success");
    }

}
