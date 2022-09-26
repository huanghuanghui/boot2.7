package cn.showcon.boot.web;

import cn.showcon.boot.MyResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/getObject")
    public MyResponse getObject() {
        return new MyResponse(200,"success");
    }

    @GetMapping("/getString")
    public String getString() {
        return "SUCCESS";
    }

}
