package cn.showcon.boot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractBusinessController {


    @GetMapping("/get")
    public String getContractSnapshot() {
        return "success";
    }

}
