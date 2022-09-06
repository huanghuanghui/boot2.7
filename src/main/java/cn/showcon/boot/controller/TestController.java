package cn.showcon.boot.controller;

import cn.showcon.boot.event.ContractModifyEventPublishEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private ContractModifyEventPublishEvent contractModifyEventPublishEvent;

    @GetMapping("/hello")
    public String hello() {
        contractModifyEventPublishEvent.publishEvent("code");
        return "Hello " ;
    }
}
