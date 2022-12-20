package cn.showcon.boot.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

@AutoConfigureAfter(ConfigurationC.class)
public class ConfigurationB {

    ConfigurationB(){
        System.out.println("ConfigurationB  已经被初始化！");
    }
}