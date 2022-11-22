package cn.showcon.boot.controller;

import cn.showcon.boot.response.MyResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/test")
    public void test(@RequestParam Integer num)throws Exception{
        List<MyResponse> myResponseList = new ArrayList<>();
        for (int i = 0; i < 1024 * 1024 * 1024; i++) {
            if (i%num==0){
                System.out.println("---------sleep 100 add num object:"+num);
                Thread.sleep(100);
            }
            myResponseList.add(new MyResponse(200, "success"));
        }
    }
}
